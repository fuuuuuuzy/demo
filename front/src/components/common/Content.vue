<template>
    <ul class="infinite-list" v-infinite-scroll="load" infinite-scroll-distance='200px'
        style="overflow:auto">
        <!-- <li v-for="i in count" :key="i" class="infinite-list-item"> -->
            <el-row v-for="news in news_s" :key="news.news_id">
                <el-col style="margin-bottom:20px">
                    <el-card :body-style="{ padding: '0px' }">
                    <!-- <img src={{news.pic_url}} class="image"> -->
                    <el-image
                        style="width: 100px; height: 100px"
                        :src="news.pic_url" :fit="fit">
                    </el-image>
                    <div style="padding: 14px;">
                        <span>{{news.news_content}}</span>
                        <div class="bottom clearfix">
                        <time class="time">{{ news.time }}</time>
                        <el-button type="text" class="button">查阅</el-button>
                        </div>
                    </div>
                    </el-card>
                </el-col>
            </el-row>
        <!-- </li> -->
    </ul>
</template>

<script>
    export default {
        data () {
            return {
                // count: 0
                news_s: [
                    {news_id:0, news_content:'aaaaaa', pic_url:'../../assets/logo.png', time:'2019-09-09 09:09:09'},
                    {news_id:1, news_content:'bbbbbb', pic_url:'../../assets/logo.png', time:'2019-09-09 09:09:09'},
                    {news_id:2, news_content:'cccccc', pic_url:'../../assets/logo.png', time:'2019-09-09 09:09:09'},
                    {news_id:3, news_content:'dddddd', pic_url:'../../assets/logo.png', time:'2019-09-09 09:09:09'},
                    {news_id:4, news_content:'eeeeee', pic_url:'../../assets/logo.png', time:'2019-09-09 09:09:09'},
                ],
            }
        },
        methods: {
            load () {
                this.count += 2
            }
        }
    }
</script>