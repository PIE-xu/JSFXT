<template>
  <div style="display: flex">
    <div class="registration-form">
      <el-form :label-width="formLabelWidth" label-position="top">
  <el-card>
    <div class="form-title">
      <h3>健身房注册信息</h3>
    </div>
    <div class="registration-form">
      <el-form-item label="健身会所名称">
        <el-input v-model="gymClub.name"></el-input>
      </el-form-item>
      <el-form-item label="简介">
        <el-input v-model="gymClub.description"></el-input>
      </el-form-item>
    </div>
    <div class="form-row">
      <el-form-item label="国家">
        <el-input v-model="gymClub.country"></el-input>
      </el-form-item>
      <el-form-item label="城市">
        <el-input v-model="gymClub.city"></el-input>
      </el-form-item>
    </div>
    <div class="form-row">
      <el-form-item label="街道地址">
        <el-input v-model="gymClub.streetAddress"></el-input>
      </el-form-item>
      <el-form-item label="联系电话">
        <el-input v-model="gymClub.phone"></el-input>
      </el-form-item>
    </div>
    <div class="form-row">
      <el-form-item label="营业时间">
        <el-input v-model="gymClub.businessHours"></el-input>
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
import { add as gymAdd } from '@/api/gymclub'
import router from "@/router";
export default {
  data() {
    return {
      gymClub: {
        name: '',
        description: '',
        country: '',
        city: '',
        streetAddress: '',
        phone: '',
        businessHours: '',
      },
    };
  },
  methods: {
    async submitForm() {
      await gymAdd(this.gymClub)
      router.replace('/index')
      // 处理表单提交逻辑
    },
    resetForm() {
      // 重置表单
      this.gymClub = {
        name: '',
        description: '',
        country: '',
        city: '',
        streetAddress: '',
        phone: '',
        businessHours: '',
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