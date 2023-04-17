<template>
    <div class="menu-container">
        <el-header v-if="showNavbar">
            <navbar></navbar>
        </el-header>
    </div>
    <router-view/>
</template>

<script>
import Navbar from "@/components/Navbar.vue";
export default {
    components: {
        Navbar // 注册导航栏组件
    },
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