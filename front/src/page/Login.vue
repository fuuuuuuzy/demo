<template>
  <div id="loginDiv">

    <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="用户名：">
            <el-input v-model="form.username" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item label="密码：">
            <el-input v-model="form.password" placeholder="请输入密码"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="login()">Login</el-button>
        </el-form-item>
        <!-- <el-form-item>
            <el-button type="primary" @click="register()">Register</el-button>
        </el-form-item> -->
    </el-form>
  </div>
</template>

<script>
    export default {
        data() {
            return {
                form: {
                    username:'NONE',
                    password:'NONE',
                }
               
            }
        },
        methods: {
            login() {
                // 需要修改需修改

                 this.$axios.post('/tuser/loginValid',{
                     username:this.form.username,
                     password:this.form.password,
                 }).then((response) => {
                 if (response.data == true){
                     this.$Message.success('登录成功!');
                     this.$router.push('index');
                 }else{
                     this.$Message.error("用户名或密码错误");
                 }
                 });

                this.$router.push('index');
            },
        }

    }
</script>

<style>
  #loginDiv{
    width: 250px;
    height: 300px;
    margin: 0 auto;
    text-align: center;
  }
</style>
