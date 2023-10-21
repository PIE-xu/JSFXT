import { createRouter, createWebHistory } from 'vue-router'
import IndexView from '../views/index.vue'
import Details from '../views/details.vue'
import LoginView from '../views/login/index.vue'
import AdminInfo from "@/views/adminInfo.vue";
import GymManage from "@/views/GymManage.vue";


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // {
    //   path: '/',
    //   name: 'home',
    //   component: HomeView
    // },
    {
      path: '/',
      name: 'index',
      component: IndexView
    },
    {
      path: '/login',
      name: 'login',
      component: LoginView
    },
    /*{
      path: '/register',
      name: 'register',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component:registerView
    },*/
    {
      path: '/details',
      name: 'details',
      component: Details
    },
    {
      path: '/adminInfo',
      name: 'adminInfo',
      component: AdminInfo
    },
    {
      path: '/gymmanage',
      name: 'gymmanage',
      component: GymManage
    }
  ]
})

export default router
