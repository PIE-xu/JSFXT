<template>
  <div style="display: flex">
    <div class="registration-form">
      <el-form :label-width="formLabelWidth" label-position="top">
        <el-card>
          <div class="form-title">
            <h3>管理员信息</h3>
          </div>
          <div class="form-row">
            <el-form-item label="用户名*">
              <el-input v-model="admin.username"></el-input>
            </el-form-item>
            <el-form-item label="密码*">
              <el-input type="password" v-model="admin.password"></el-input>
            </el-form-item>
          </div>
          <div class="form-row">
            <el-form-item label="真实姓名*">
              <el-input v-model="admin.name"></el-input>
            </el-form-item>
            <el-form-item label="电子邮件*">
              <el-input v-model="admin.email"></el-input>
            </el-form-item>
          </div>
          <div class="form-row">
            <el-form-item label="手机号码">
              <el-input v-model="admin.phone"></el-input>
            </el-form-item>
          </div>
        </el-card>
        <el-row>
          <el-col :span="12">
            <el-button type="primary" @click="submitForm">提交注册</el-button>
          </el-col>
          <el-col :span="12">
            <el-button @click="resetForm">重置信息</el-button>
          </el-col>
        </el-row>
      </el-form>
    </div>
  </div>

</template>



<script>
import { add as adminAdd } from '@/api/admin'
import router from "@/router";
export default {
  data() {
    return {
      formLabelWidth: '150px',
      admin: {
        username: '',
        password: '',
        name: '',
        email: '',
        phone: '',
        managedGym: '',
      },
    };
  },
  methods: {
    async submitForm() {
      await adminAdd(this.admin)
      router.replace('/login')
      // 处理表单提交逻辑
    },
    resetForm() {
      // 重置表单
      this.admin = {
        username: '',
        password: '',
        name: '',
        email: '',
        phone: '',
        managedGym: '',
      };
    },
  },
};
</script>

<style>
.registration-form {
  width: 55%;
  margin: 0 auto;
  text-align: center;
  background-color: yellow;
  display: flex;
  align-content: stretch;
  flex-direction: column;
  flex-wrap: wrap;
  align-items: center;
}

.form-title {
  background-color: yellow;
  padding: 10px;
  margin-bottom: 10px;
  text-align: center;
}
.form-row {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
</style>
