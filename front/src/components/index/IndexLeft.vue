
<template>
  <div>
    <el-row class="tac" style="width: 250px">
      <el-col>
        <!-- <h5>默认颜色</h5> -->
        <el-menu default-active="1" class="el-menu-vertical-demo">
          <el-menu-item index="1">
            <span slot="title">导航一</span>
          </el-menu-item>
          <el-menu-item index="2">
            <span slot="title">导航二</span>
          </el-menu-item>
          <el-menu-item index="3">
            <span slot="title">导航三</span>
          </el-menu-item>
        </el-menu>
      </el-col>
    </el-row>
  </div>
</template>

<script>

export default {
    
}
</script>
