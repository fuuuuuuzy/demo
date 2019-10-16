<template>
    <el-tabs v-model="activeName">
        <!-- 这是单个标签 -->
        <el-tab-pane v-for="(tag, index) in tags" :key="index" v-bind:label="tag" v-bind:name="tag">
            <!-- 这是单张卡片 -->
            <el-row v-for="news in news_s" :key="news.news_id"  @tab-click="handleClick(tag)">
                <el-col style="margin-bottom:20px">
                    <el-card :body-style="{ padding: '0px' }">
                        <el-image
                            style="width: 100px; height: 100px"
                            v-bind:src="news.pic_url">
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
        </el-tab-pane>
    </el-tabs>

</template>

<script>
    export default {
        props:['tags'],
        data () {
            return {
                // count: 0
                news_s: [
                    {news_id:0, news_content:'aaaaaa', pic_url:require('../../assets/logo.png'), time:'2019-09-09 09:09:09'},
                    {news_id:1, news_content:'bbbbbb', pic_url:require('../../assets/logo.png'), time:'2019-09-09 09:09:09'},
                    {news_id:2, news_content:'cccccc', pic_url:require('../../assets/logo.png'), time:'2019-09-09 09:09:09'},
                    {news_id:3, news_content:'dddddd', pic_url:require('../../assets/logo.png'), time:'2019-09-09 09:09:09'},
                    {news_id:4, news_content:'eeeeee', pic_url:require('../../assets/logo.png'), time:'2019-09-09 09:09:09'},
                ],
                activeName: this.tags[0],
            }
        },
        methods: {
            load () {
                this.count += 2
            },
            handleClick(tag) {
                console.log(tag);
            },
        }
    }

</script>
