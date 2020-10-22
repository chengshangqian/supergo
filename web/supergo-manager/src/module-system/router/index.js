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
    path: '/system',
    component: Layout,
    redirect: 'noredirect',
    name: '系统管理',
    meta: {
      title: '系统管理',
      icon: 'component'
    },
    children: [
      {
        path: 'user', // 请求地址
        component: _import('system/pages/user'), // 跳转的vue视图
        name: 'demo-user',
        meta: {title: '用户管理', icon: 'component', noCache: true}
      },
      {
        path: 'role', // 请求地址
        component: _import('system/pages/role'), // 跳转的vue视图
        name: 'demo-role',
        meta: {title: '角色管理', icon: 'component', noCache: true}
      },
      {
        path: 'authority', // 请求地址
        component: _import('system/pages/authority'), // 跳转的vue视图
        name: 'demo-ads-authority',
        meta: {title: '权限管理', icon: 'component', noCache: true}
      }
    ]
  }
]
