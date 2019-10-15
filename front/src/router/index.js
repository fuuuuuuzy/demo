// 页面路由组件

import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
// import BlogLogin from '@/components/manage/BlogLogin.vue'
// import BlogIndex from '@/components/home/BlogIndex.vue'

import Login from '../page/Login'
import Index from '../page/Index'


Vue.use(Router)

// export default new Router({
//   routes: [
//     {
//       path: '/',
//       name: 'HelloWorld',
//       component: HelloWorld
//     }
//   ]
// })

export default new Router({
  routes: [
    {
      path:"/",
      alias:'/login',
      name:"login",
      component:Login,
    },
    {
        path:"/index",
        name:"Index",
        component:Index,
    },
    // {
    //   path: '/login',
    //   name: 'Login',
    //   component: Login
    // }
    // {
    //   path: '/index',
    //   name: 'BlogIndex',
    //   component: BlogIndex
    // },
    // {
    //   path: '/manage',
    //   redirect: '/login'
    // },

  ]
})