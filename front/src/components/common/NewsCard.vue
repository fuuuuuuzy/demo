// 可能暂时用不上


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



                label="{{tab}}" name="{{index}}"