<template>
  <div class="gym-club-title">
    <el-button type="primary" :icon="HomeFilled" @click="this.goHome">回到首页</el-button>
    <h3 style="text-align: center">健身房详细信息列表</h3>
  </div>
  <el-row :gutter="20" class="header">
    <el-col :span="7">
      <el-input placeholder="请输入健身俱乐部名称" clearable v-model="queryForm.query">
      </el-input>
    </el-col>
    <el-button type="primary" :icon="Search" @click="this.getDetailsGyms">搜索</el-button>
  </el-row>
  <div class="gym-club-list">
    <div v-for="gymClub in gymClubs" :key="gymClub.id" class="gym-club-card">
      <div class="gym-club-card-left">
        <img :src="gymClub.image" alt="Gym Image" class="gym-image" />
      </div>
      <div class="gym-club-card-right">
        <div class="gym-club-name">{{ gymClub.name }}</div>
        <el-form :model="gymClub" label-position="left" label-width="120px">
          <el-form-item label="Description">
            {{ gymClub.description }}
          </el-form-item>
          <el-form-item label="Country">
            {{ gymClub.country }}
          </el-form-item>
          <el-form-item label="City">
            {{ gymClub.city }}
          </el-form-item>
          <el-form-item label="Street Address">
            {{ gymClub.streetAddress }}
          </el-form-item>
          <el-form-item label="Phone">
            {{ gymClub.phone }}
          </el-form-item>
          <el-form-item label="Business Hours">
            {{ gymClub.businessHours }}
          </el-form-item>
          <el-form-item label="Average Rating">
            {{ gymClub.averageRating }}
          </el-form-item>
        </el-form>
      </div>
      <div class="gym-club-right">
        <div class="gym-club-equipment">
          <h3>Equipment</h3>
          <ul>
            <li v-for="equipment in gymClub.equipment" :key="equipment.id">
              <strong>{{ equipment.name }}:</strong> {{ equipment.description }} (Quantity: {{ equipment.quantity }})
            </li>
          </ul>
        </div>
        <div class="gym-club-coaches">
          <h3>Coaches</h3>
          <ul>
            <li v-for="coach in gymClub.coaches" :key="coach.id">
              <strong>{{ coach.name }}:</strong> {{ coach.contactInfo }} (Qualifications: {{ coach.qualifications }})
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <el-pagination
      class="fenye"
      v-model:current-page="queryForm.pagenum"
      v-model:page-size="queryForm.pagesize"
      :page-sizes="[1, 2, 4, 6]"
      layout="total, sizes, prev, pager, next, jumper"
      :total="queryForm.total"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
  />
</template>


<script>
import {getGymList} from '@/api/gymclub'
import {getEquipmentByAdminId} from '@/api/equipment'
import {Search,HomeFilled} from "@element-plus/icons-vue";
import router from "@/router";
export default {
  computed: {
    HomeFilled() {
      return HomeFilled
    },
    Search() {
      return Search
    }
  },
  data() {
    return {
      gymClubs: [],
      queryForm: {
        query: '',
        pagenum: 1,
        pagesize: 3,
        total:0,
      }
    };
  },
  created() {
    this.getDetailsGyms()
  },
  methods: {
    async getDetailsGyms() {
      const tempgym = await getGymList(this.queryForm);
      this.gymClubs = tempgym.data.records
      this.queryForm.total = tempgym.data.total
      // await this.getDetailsEquipmentByAdminId(this.queryForm.total)
    },
    handleSizeChange(pageSize) {
      this.queryForm.pagenum = 1
      this.queryForm.pagesize = pageSize
      this.getDetailsGyms()
    },
    handleCurrentChange(pageNum) {
      this.queryForm.pagenum = pageNum
      this.getDetailsGyms()
    },
    goHome(){
      router.push('/')
    }
/*    async getDetailsEquipmentByAdminId(total) {
      for (let i = 1; i < total; i++) {
        const tempEquipment = await getEquipmentByAdminId(i)
        this.gymClubs.forEach(gym => {
          if (gym.equipment === null & gym.id === i) {
            // 如果equipment属性为null，你可以添加一个新的equipment对象
            gym.equipment = tempEquipment.data
          }
        })
        this.gymClubs.forEach(gym => {
          console.log(gym);
        })
        // console.log("this.gymClubs[i].equipment"+JSON.stringify(this.gymClubs))
      }

    }*/
  }
}
</script>

<style>
.gym-club-title{
  display: flex;
  justify-content: space-between;
  align-items: center;
  flex-direction: column;
}
.header{
  padding: 16px;
  box-sizing: border-box;
  justify-content: center;
}
.gym-club-list {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  margin: 10px;
}

.gym-club-card {
  width: 80%;
  background-color: #fff;
  margin: 10px;
  padding: 10px;
  border: 1px solid #ccc;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  display: flex;
}

.gym-club-card-left {
  width: 30%;
  padding: 10px;
}

.gym-image {
  max-width: 100%;
}

.gym-club-card-right {
  width: 70%;
}

.gym-club-name {
  font-size: 24px;
  color: #00bfff; /* Light Blue */
  margin-bottom: 10px;
}
.gym-club-right {
  width: 30%;
  padding: 10px;
  background-color: #fff;
  border: 1px solid #ccc;
}

.gym-club-equipment h3,
.gym-club-coaches h3 {
  color: #00bfff; /* Light Blue */
}

.gym-club-equipment ul,
.gym-club-coaches ul {
  list-style: none;
  padding: 0;
  margin: 0;
}

.gym-club-equipment li,
.gym-club-coaches li {
  margin: 5px 0;
  color: #00bfff; /* Light Blue */
}
.gym-club-equipment ul,
.gym-club-coaches ul {
  list-style: none;
  padding: 0;
  margin: 20px 0; /* 增加上下间距为 20px */
}

.gym-club-equipment li,
.gym-club-coaches li {
  margin: 5px 0;
  color: #00bfff; /* Light Blue */
}
.fenye{
  margin-left: 300px;
}
</style>
