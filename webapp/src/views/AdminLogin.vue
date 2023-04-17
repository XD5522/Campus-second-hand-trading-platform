<template>
    <div class="login-container">
        <el-form ref="loginForm" :model="loginForm" label-width="80px">
            <h1 class="login-title">登录</h1>
            <el-form-item label="用户名" prop="username">
                <el-input v-model="loginForm.username" placeholder="请输入用户名"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
                <el-input v-model="loginForm.password" type="password" placeholder="请输入密码"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="handleLogin">登录</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script lang="ts">
import { Vue, Component } from 'vue-property-decorator';
import { ElForm, ElFormItem, ElInput, ElButton } from 'element-plus';

@Component({
    components: {
        ElForm,
        ElFormItem,
        ElInput,
        ElButton
    }
})
export default class LoginPage extends Vue {
    loginForm = {
        username: '',
        password: ''
    };

    handleLogin() {
        // 登录逻辑
        console.log('登录成功');
    }
}
</script>

<style scoped>
.login-container {
    width: 300px;
    margin: 100px auto;
}

.login-title {
    text-align: center;
    margin-bottom: 20px;
}
</style>