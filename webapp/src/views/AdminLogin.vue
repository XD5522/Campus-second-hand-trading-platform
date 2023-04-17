<template>

    <div class="login-container">
        <el-card class="login-card">
            <div class="login-logo">
<!--                <img src="./assets/logo.png" alt="Logo">-->
                <h1 class="login-title">登录</h1>
            </div>
            <el-form ref="loginForm" :model="loginForm" :rules="loginFormRules" class="login-form">
                <el-form-item prop="username">
                    <el-input v-model="loginForm.username" placeholder="请输入账号"></el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input v-model="loginForm.password" type="password" placeholder="请输入密码"></el-input>
                </el-form-item>
                <el-form-item class="login-btn-container">
                    <el-button type="primary" @click="login" :loading="loading">登录</el-button>
                </el-form-item>
            </el-form>
        </el-card>
    </div>
</template>

<script>
export default {
    data() {
        return {
            loginForm: {
                username: '',
                password: ''
            },
            loginFormRules: {
                username: [{ required: true, message: '请输入账号', trigger: 'blur' }],
                password: [{ required: true, message: '请输入密码', trigger: 'blur' }]
            },
            loading: false
        };
    },
    methods: {
        login() {
            this.$refs.loginForm.validate(valid => {
                if (valid) {
                    // 发送登录请求
                    this.loading = true;
                    setTimeout(() => {
                        // 模拟登录成功
                        this.loading = false;
                        this.$message.success('登录成功');
                        // 跳转到首页
                        this.$router.push('/home');
                    }, 1000);
                } else {
                    this.$message.error('请填写完整的登录信息');
                    return false;
                }
            });
        }
    }
};
</script>

<style scoped>
.login-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.login-card {
    width: 400px;
    padding: 20px;
}

.login-logo {
    text-align: center;
    margin-bottom: 20px;
}

.login-title {
    font-size: 24px;
    margin-top: 10px;
}

.login-form {
    margin-top: 20px;
}

.login-btn-container {
    text-align: center;
    margin-top: 20px;
}
</style>
