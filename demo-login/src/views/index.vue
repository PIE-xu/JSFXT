<template>
  <div class="gym-promo">
    <!-- 顶部导航栏 -->
    <el-header class="promo-header">
      <div class="promo-nav">
        <div class="promo-button">
          <el-button type="warning" round class="join-button">加入我们</el-button>
        </div>
      </div>
    </el-header>

    <!-- 轮播图 -->
    <el-carousel class="promo-carousel" :interval="4000" height="300px">
      <el-carousel-item v-for="item in carouselItems" :key="item.id">
        <img :src="item.image" alt="轮播图" style="width: 100%" />
      </el-carousel-item>
    </el-carousel>

    <!-- 推荐健身房卡片 -->
    <div class="promo-recommendation">
      <el-card v-for="gym in recommendedGyms" :key="gym.id" class="promo-card">
        <div class="promo-image">
          <img :src="gym.image" alt="健身房图片" style="width: 70%;" />
        </div>
        <div class="promo-details">
          <h4>{{ gym.name }}</h4>
          <p>{{ gym.description }}</p>
          <el-button type="primary" round>了解更多</el-button>
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
export default {
  name: "GymPromo",
  data() {
    return {
      carouselItems: [
        { id: 1, image: "public/image/gym1.jpeg" },
        { id: 2, image: "public/image/gym2.jpeg" },
        { id: 3, image: "public/image/gym3.jpg" },
      ],
      recommendedGyms: [
        {
          id: 1,
          name: "健身房 A",
          description: "顶级设备，专业教练，全天开放。",
          image: "public/image/gym_a.jpg",
        },
        {
          id: 2,
          name: "健身房 B",
          description: "宽敞空间，个性化训练计划。",
          image: "public/image/gym_b.jpg",
        },
        {
          id: 3,
          name: "健身房 C",
          description: "瑜伽，有氧，无氧，多种选择。",
          image: "public/image/gym_c.jpeg",
        }]
    };
  },
}
</script>

<style scoped>
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
  justify-content: flex-end;
  align-items: center; /* 垂直居中 */
}

.promo-button {
  margin-right: 30%; /* 向右偏移30% */
}

.join-button {
  border-radius: 5px; /* 圆角正方形 */
  background-color: #FFD700; /* 亮黄色 */
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
