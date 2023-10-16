import { createRouter, createWebHistory } from 'vue-router'
import indexView from '../views/index.vue'
import Details from '../views/details.vue'
import LoginView from '../views/login/index.vue'


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
      component: indexView
    },
    {
      path: '/login',
      name: 'login',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component:LoginView
    },
    {
      path: '/details',
      name: 'details',
      component: Details
    }
  ]
})

export default router
