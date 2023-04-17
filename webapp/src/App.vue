<template>
    <div class="menu-container">
        <el-header v-if="showNavbar">
            <el-menu
                    :default-active="activeIndex"
                    class="el-menu-demo"
                    mode="horizontal"
                    :ellipsis="false"
                    @select="handleSelect"
            >
                <el-menu-item index="/">LOGO</el-menu-item>
                <div class="flex-grow"/>
                <el-menu-item index="/about">首页</el-menu-item>
                <el-menu-item index="/about">哈哈哈</el-menu-item>
                <el-menu-item index="/about">哈哈哈哈</el-menu-item>
                <el-menu-item index="/about">呜呜呜呜</el-menu-item>
                <div class="flex-grow"/>
                <!--            <img src="./assets/Account-picture.png" >-->

                <el-sub-menu index="2">
                    <template #title>用户名</template>
                    <el-menu-item index="2-1">个人中心</el-menu-item>
                    <el-menu-item index="2-2">购物车</el-menu-item>
                    <el-menu-item index="2-3">注销</el-menu-item>
                </el-sub-menu>
            </el-menu>
        </el-header>
    </div>


    <router-view/>
</template>

<script>
export default {
    data() {
        return {
            showNavbar: true//showNavbar属性标记导航栏的可见性
        };
    },
    watch: {
        '$route': function (newRoute, oldRoute) {
            // 监听 $route 对象的变化
            const hideNavbar = newRoute.meta.hideNavbar; // 获取当前路由的 meta 字段中的 hideNavbar 属性值
            this.showNavbar = !hideNavbar; // 设置 showNavbar 的值，根据 hideNavbar 的值决定是否显示导航栏
        }
    }
};
</script>
<style>
#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
}


.menu-container {
    height: 80px;
}

el-menu {
    height: 100%;
}


.flex-grow {
    flex-grow: 1;
}

nav {
    padding: 30px;
}

nav a {
    font-weight: bold;
    color: #2c3e50;
}


</style>
<script setup>
</script>