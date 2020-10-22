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
    // root: true,
    path: '/store',
    component: Layout,
    redirect: 'noredirect',
    name: '商家管理',
    meta: {
      title: '商家管理',
      icon: 'component'
    },
    children: [
      {
        path: 'application', // 请求地址
        component: _import('store/pages/application'), // 跳转的vue视图
        name: 'demo-application',
        meta: {title: '商家审核', icon: 'component', noCache: true}
      },
      {
        path: 'management', // 请求地址
        component: _import('store/pages/management'), // 跳转的vue视图
        name: 'demo-management',
        meta: {title: '商家管理', icon: 'component', noCache: true}
      }
    ]
  }
]
