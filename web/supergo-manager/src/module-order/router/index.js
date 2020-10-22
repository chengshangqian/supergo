/*
 * @Author: hubin
 * @Description: xxx业务模块
 * @Date: 2018-04-13 16:13:27
 * @Last Modified by: hubin
 * @Last Modified time: 2018-09-03 11:12:47
 */

import Layout from '@/module-dashboard/pages/layout'
const _import = require('@/router/import_' + process.env.NODE_ENV)

export default [
  {
    //root: true,
    path: '/order',
    component: Layout,
    redirect: 'noredirect',
    name: '订单管理',
    meta: {
      title: '订单管理',
      icon: 'component'
    },
    children: [
      {
        path: 'return', // 请求地址
        component: _import('order/pages/return'), // 跳转的vue视图
        name: 'demo-return',
        meta: {title: '订单退货管理', icon: 'component', noCache: true}
      },
      {
        path: 'change', // 请求地址
        component: _import('order/pages/change'), // 跳转的vue视图
        name: 'demo-change',
        meta: {title: '订单换货管理', icon: 'component', noCache: true}
      },
      {
        path: 'return_bill', // 请求地址
        component: _import('order/pages/return_bill'), // 跳转的vue视图
        name: 'demo-return_bill',
        meta: {title: '退货单管理', icon: 'component', noCache: true}
      }
    ]
  }
]
