<template>
    <el-card class="box-card">
        <div slot="header" class="clearfix">
            <span>热门话题</span>
            <!-- <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button> -->
            <el-button style="float: right; padding: 1px" type="primary" icon="el-icon-refresh" :click="refreshNews()" circle></el-button>
        </div>
        <div v-for="hot_news in hot_news_s" :key="hot_news.news_id">
            <el-link type="primary">{{hot_news.news_content}} {{hot_news.news_id}}</el-link>
        </div>
    </el-card>
</template>


<script>

export default {
    data() {
        return {
            hot_news_s: [
                {news_id:0, news_content:'aaaaaa'},
                {news_id:1, news_content:'bbbbbb'},
                {news_id:2, news_content:'cccccc'},
                {news_id:3, news_content:'dddddd'},
                {news_id:4, news_content:'eeeeee'},
            ],
        }
    },
    created() {
        // 获得热点新闻列表

        // this.$axios.post('/api/index/getHotNewsList').then(response => {
        //     this.hot_news_s = response.data;
        // })
    },
    methods: {
        refreshNews() {
            // 获得热点新闻列表
            
            // this.$axios.post('/api/index/getHotNewsList').then((response) => {
            // if (response.data == true){
            //     this.$Message.success('刷新成功!');
            //     this.hot_news_s = response.data;
            // }else{
            //     this.$Message.error("刷新失败");
            // }
            // });
        },
    }

}
</script>