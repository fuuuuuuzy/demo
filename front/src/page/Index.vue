<template>
    <el-container style="width:1200px;margin: auto;">
        <el-header style="margin-bottom:60px">
            <topBar></topBar>
        </el-header>
        <el-container id="main-container" style="width:1200px;margin: auto;">
            <el-aside width="250px">
                <indexLeft></indexLeft>
            </el-aside>
            <el-main>
                <contentArea></contentArea>
                </el-main>
            <el-aside width="250px">
                <indexRight></indexRight>
            </el-aside>
        </el-container>
    </el-container>
</template>

<script>
import indexLeft from '@/components/index/IndexLeft.vue'
import indexRight from '@/components/index/IndexRight.vue'
import indexEdit from '@/components/index/IndexEdit.vue'
import topBar from '@/components/common/Top.vue'
import contentArea from '@/components/common/Content.vue'

export default {
  components: { indexLeft, indexRight, indexEdit, topBar, contentArea }
}
</script>


<style scoped>
    /* #main-container{
        margin: auto; 
        width: 1200px
    } */
</style>