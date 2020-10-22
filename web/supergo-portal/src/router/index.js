import Vue from 'vue'
import Router from 'vue-router'
// 引入首页
import index from '@/components/index'
// 引入side
import side from '@/components/public/side-panel'
// 引入登录页
import login from '@/components/login/login'
// 引入注册页
import register from '@/components/register/register'
// 引入搜索页
import seachGoods from '@/components/goods/seachGoods'
// 引入商品详情页
import item from '@/components/item/item'
// 引入购物车页
import cart from '@/components/cart/cart'
// 引入订单信息页
import getOrderInfo from '@/components/getOrderInfo/getOrderInfo'
// 引入home页
import home from '@/components/home/home'
// 引入支付页
import pay from '@/components/pay/pay'
// 引入支付成功页
import paysuccess from '@/components/pay/paysuccess'
// 引入支付失败页
import payfail from '@/components/pay/payfail'
// 引入账户安全页
import account from '@/components/account/account'
// 引入订单中心页
import order from '@/components/account/order'
// 引入我的中心页
import personCollect from '@/components/account/personCollect'
// 引入个人信息页
import settingInfo from '@/components/account/setting-info'
// 引入地址管理页
import settingAddress from '@/components/account/setting-address'
// 引入安全管理页
import settingSafe from '@/components/account/setting-safe'
// 引入秒杀页
import spike from '@/components/spike/spike'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/index'
    },
    {
      path: '/index',
      component: index
    },
    {
      path: '/login',
      component: login
    },
    {
      path: '/register',
      component: register
    },
    {
      path: '/seachGoods',
      component: seachGoods
    },
    {
      path: '/cart',
      component: cart
    },
    {
      path: '/getOrderInfo',
      component: getOrderInfo
    },
    {
      path: '/home',
      component: home
    },
    {
      path: '/item',
      component: item
    },  
    {
      path: '/pay',
      component: pay
    },
    {
      path: '/paysuccess',
      component: paysuccess
    },  
    {
      path: '/payfail',
      component: payfail
    },
    {
      path: '/side',
      component: side
    },
    {
      path: '/spike',
      component: spike
    },
    {
      path: '/account',
      component: account,
      // redirect:'/account/order'
      children:[
        {
          path: '/account/order',
          component: order
        },
        {
          path: '/account/personCollect',
          component: personCollect
        },
        {
          path: '/account/settingInfo',
          component: settingInfo
        },
        {
          path: '/account/settingAddress',
          component: settingAddress
        },
        {
          path: '/account/settingSafe',
          component: settingSafe
        },
      ]
    }, 
    // {
    //   path: '/account',
    //   component: account
    // },
  ]
})
