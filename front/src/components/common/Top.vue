// 页面尾部组件

<template>
    <el-container>
        <el-aside>

            <!-- <router-link :to="{name:'book',params:{bookId:book.bookId}}" >
                  <img :src="book.bookCover" 
                    style="width: 80px; height: 80px" class="bookImg">
            </router-link> -->

            <img src="../../assets/logo.png"
                style="width: 80px; height: 80px"
                :click="returnIndex()">
        </el-aside>
        <el-main>
            <el-input placeholder="请输入内容" prefix-icon="el-icon-search" v-model="key_words">
            </el-input>
        </el-main>
    </el-container>
</template>

<script>
export default {
    data() {
        return {
            key_words: '请输入关键字'
        }
    },
    methods: {
        returnIndex() {
            this.$router.push({ path:"/index" });
        },
    }
}
</script>