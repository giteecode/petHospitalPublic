<template>
  <div style="color: #666;font-size: 14px;">
    <div style="padding-bottom: 20px">
      <b>欢迎你！{{ user.nickname }}</b>
    </div>
    <el-card>
      加油！！！！ 一起学习
      <el-divider />
      宠物服务系统，学习项目分享
    </el-card>
    <div style="height: 1px; background: #ddd; margin: 20px 0"/>

    <el-row :gutter="30">
      <el-col :span="12">
        <div style="padding: 20px 0; font-size: 20px">宠物服务系统</div>
        <div>
          这是一个宠物服务系统，前端和后端代码简单清晰，适合小白学习
        </div>
        <div class="m-10"><el-button type="danger"><i class="el-icon-coin"></i> 免费开源</el-button></div>
        <div class="m-10">
          <el-button type="primary"><i class="el-icon-link"></i> <a style="color: #fff" href="https://github.com/lubenchu/pet_hospital_fronted.git">GitHub 前端代码</a></el-button>
          <el-button type="primary"><i class="el-icon-link"></i> <a style="color: #fff" href="https://github.com/lubenchu/pet_hospital_backed.git">GitHub 后端代码</a></el-button>
        </div>
      </el-col>
      <el-col :span="12">
        <div style="padding: 20px 0; font-size: 20px">技术栈</div>
        <el-row>
          <el-col :span="12" style="line-height: 30px">
            <div><b>后端</b></div>
            <div>SpringBoot2</div>
            <div>Hutool</div>
            <div>Poi</div>
            <div>Lombok</div>
            <div>Mybatis/Mybatis-plus</div>
          </el-col>
          <el-col :span="12" style="line-height: 30px">
            <b>前端</b>
            <div>Vue2</div>
            <div>Vue-Router</div>
            <div>VueX</div>
            <div>ElementUI</div>
            <div>Axios</div>
          </el-col>
        </el-row>
      </el-col>
    </el-row>


  </div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
    }
  }
}
</script>
