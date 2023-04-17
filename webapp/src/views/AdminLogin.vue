<template>
    <div class="login-container">
        <el-card class="login-card">
            <div class="login-form">
                <h2 class="login-title">用户登录</h2>
                <el-form ref="loginForm" :model="form" :rules="rules" label-width="0px">
                    <el-form-item prop="username">
                        <el-input v-model="form.username" placeholder="请输入用户名"></el-input>
                    </el-form-item>
                    <el-form-item prop="password">
                        <el-input type="password" v-model="form.password" placeholder="请输入密码"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="handleLogin">登录</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </el-card>
    </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import { ElForm, ElFormItem, ElInput, ElButton, ElCard } from 'element-plus';
import 'element-plus/lib/theme-chalk/index.css';

interface Form {
    username: string;
    password: string;
}

export default defineComponent({
    name: 'Login',
    components: {
        ElForm,
        ElFormItem,
        ElInput,
        ElButton,
        ElCard
    },
    data() {
        return {
            form: {
                username: '',
                password: ''
            } as Form,
            rules: {
                username: [
                    { required: true, message: '请输入用户名', trigger: 'blur' }
                ],
                password: [
                    { required: true, message: '请输入密码', trigger: 'blur' }
                ]
            }
        };
    },
    methods: {
        handleLogin() {
            (this.$refs.loginForm as any).validate(valid => {
                if (valid) {
                    // 发送登录请求
                    console.log('登录成功');
                } else {
                    console.log('登录失败');
                    return false;
                }
            });
        }
    }
});
</script>

<style scoped>
.login-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.login-card {
    width: 360px;
}

.login-form {
    padding: 20px;
}

.login-title {
    text-align: center;
    margin-bottom: 20px;
}
</style>
