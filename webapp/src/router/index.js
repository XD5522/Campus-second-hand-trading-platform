import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/AdminLogin',
    name: 'AdminLogin',
    component: import(/* webpackChunkName: "about" */ '../views/AdminLogin.vue'),
    meta: {
      hideNavbar: true //隐藏导航栏
    }
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue'),
  },
  {
    path: '/admin',
    name: 'AdminMain',
    component: () => import('../views/AdminMain.vue'),
    meta: {
      hideNavbar: true //隐藏导航栏
    }
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
