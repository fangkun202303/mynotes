import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/Index'
import IndexAdd from '@/components/IndexAdd'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path:'/',
      redirect:'/index'
    },
    {
      path: '/index',
      name: 'Index',
      component: Index,
      children: [
        {
          path: '/indexAdd',
          name: 'IndexAdd',
          component: IndexAdd,
        }
      ]
    },
  ]
})
