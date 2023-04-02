<template>
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
        <el-menu-item index="/about">[头像]</el-menu-item>

        <el-sub-menu index="2">
            <template #title>用户名</template>
            <el-menu-item index="2-1">个人中心</el-menu-item>
            <el-menu-item index="2-2">购物车</el-menu-item>
            <el-menu-item index="2-3">注销</el-menu-item>
        </el-sub-menu>
    </el-menu>


    <router-view/>
</template>

<style>


img {
    max-width: 100%;
    max-height: 100%;
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