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
    path: '/advertisement',
    component: Layout,
    redirect: 'noredirect',
    name: '广告管理',
    meta: {
      title: '广告管理',
      icon: 'component'
    },
    children: [
      {
        path: 'ads_type', // 请求地址
        component: _import('advertisement/pages/ads_type'), // 跳转的vue视图
        name: 'demo-adsType',
        meta: {title: '广告类型管理', icon: 'component', noCache: true}
      },
      {
        path: 'management', // 请求地址
        component: _import('advertisement/pages/management'), // 跳转的vue视图
        name: 'demo-ads-management',
        meta: {title: '广告管理', icon: 'component', noCache: true}
      }
    ]
  }
]
