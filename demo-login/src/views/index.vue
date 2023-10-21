<template>
  <div class="gym-promo">
    <!-- 顶部导航栏 -->
    <el-header class="promo-header">
      <div class="promo-nav">
        <h3 class="title">健身俱乐部共享平台</h3>
        <div class="promo-button">
          <el-button type="warning" :icon="CirclePlus" class="join-button" @click="joinUs" v-if="!username">加入我们</el-button>
          <el-button type="warning" :icon="Setting" class="manage_edit" @click="manageEdit" v-if="username">健身房管理</el-button>
          <el-button type="warning" :icon="Sunset" class="login-button" @click="login" v-if="!username">已有账号？立即登录</el-button>
          <el-button type="warning" :icon="Sunset" class="login-button" @click="goAddGym" v-if="admin.managedGym===0">添加俱乐部</el-button>
        </div>
      </div>
    </el-header>

    <!-- 轮播图 -->
    <el-carousel class="promo-carousel" :interval="4000" height="700px">
      <el-carousel-item v-for="item in carouselItems" :key="item.id">
        <img :src="item.image" alt="轮播图" style="width: 100%" />
      </el-carousel-item>
    </el-carousel>

    <!-- 推荐健身房卡片 -->
    <div class="promo-recommendation">
      <el-card v-for="gym in recommendedGyms" :key="gym.id" class="promo-card">
        <div class="promo-image">
          <img :src="gym.image" alt="健身房图片" style="width: 100%;" />
        </div>
        <div class="promo-details">
          <h4>{{ gym.name }}</h4>
          <p>{{ gym.description }}</p>
          <el-button type="primary" round @click="getMore">了解更多</el-button>
        </div>
      </el-card>
    </div>

    <el-card class="promo-special-card">
      <div slot="header" class="promo-card-title">本月特别活动</div>
      <div class="promo-card-content">免费瑜伽课程每周三和周五下午。不要错过这个机会，加入我们的瑜伽团队。</div>
    </el-card>

    <!-- 会员成功故事卡片 -->
    <el-card class="promo-success-card">
      <div slot="header" class="promo-card-title">会员成功故事</div>
      <div class="promo-card-content">我在这个健身房锻炼了一年，减掉了30磅体重。这里的教练和课程都很棒！</div>
    </el-card>
  </div>
</template>
<script>
import  {getGymById,} from '@/api/gymclub.js'
import router from "@/router";
import {CirclePlus, Setting, Sunset} from "@element-plus/icons-vue";
import { getAdmin } from '@/api/admin'
export default {
  name: "GymPromo",
  computed: {
    Sunset() {
      return Sunset
    },
    Setting() {
      return Setting
    },
    CirclePlus() {
      return CirclePlus
    }
  },
  data() {
    return {
      admin: {
        id: '',
        username: '',
        password: '',
        name: '',
        email: '',
        phone: '',
        managedGym: '',
      },
      username: '',
      carouselItems: [
        { id: 1, image: "public/image/gym1.jpeg" },
        { id: 2, image: "public/image/gym2.jpeg" },
        { id: 3, image: "public/image/gym3.jpg" },
      ],
      recommendedGyms: [],
      // 创建一个新对象，将后端数据的属性映射到前端属性中

    };
  },
  created() {
    this.getRecommendedGyms(); // 在组件创建时调用获取数据的方法
    this.init();
  },
  methods: {
    //获得推荐健身房数据
    async getRecommendedGyms() {
      try {
        // 使用异步方法获取每个健身房的数据
        const gym1 = await getGymById(1);
        gym1.data.image = "public/image/gym_a.jpg"
        const gym2 = await getGymById(2);
        gym2.data.image = "public/image/gym_b.jpg"
        const gym3 = await getGymById(3);
        gym3.data.image = "public/image/gym_c.jpeg"
        // 将数据填充到recommendedGyms数组中
        this.recommendedGyms.push(gym1.data, gym2.data, gym3.data);
      } catch (error) {
        console.error('Failed to fetch gym data', error);
      }
    },
    getMore() {
      router.push('/details')
    },
    joinUs() {
      router.push('/adminInfo')
    },
    manageEdit() {
      router.push('/gymmanage')
    },
    login() {
      router.push('/login')
    },
    init() {
      this.admin.username = localStorage.getItem('username') || null
      getAdmin(this.admin).then(res => {
        this.admin = res.data
        console.log(this.admin.managedGym);
      })
    },
    goAddGym(){
      router.push('/addgym')
    }
  },

}
</script>

<style scoped>
.title{
  color: white;
}

.gym-promo {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.promo-header {
  background-color: #1890ff; /* 白色 */
  width: 100%; /* 占页面宽度100% */
}

.promo-nav {
  margin-top: 15px;
  display: flex;
  justify-content: space-between;
  align-items: center; /* 垂直居中 */
}

.promo-button {
  margin-right: 20%; /* 向右偏移30% */
}

.join-button {
  background-color: #FFD700; /* 亮黄色 */
}
.login-button {
  background-color: #FFD770;
}

.promo-carousel {
  width: 80%;
  margin-top: 20px;
}

.promo-recommendation {
  display: flex;
  justify-content: space-around;
  width: 80%;
  margin-top: 20px;
}

.promo-card {
  width: 250px;
  height: 400px; /* 调高一倍 */
}

.promo-image {
  margin-bottom: 10px;
}

.promo-image img {
  width: 70%; /* 图片占比70% */
}

.promo-details h4 {
  margin: 10px 0;
}

.promo-details p {
  margin: 10px 0;
}
/* 特别活动和会员成功故事卡片样式 */
.promo-special-card, .promo-success-card {
  width: 100%;
  text-align: center;
  border: none;
  margin: 20px 0;
}

.promo-card-title {
  text-align: left;
  font-weight: bold;
  color: #409EFF; /* 浅蓝色 */
}

.promo-card-content {
  text-align: center;
  color: #666;
}

</style>
