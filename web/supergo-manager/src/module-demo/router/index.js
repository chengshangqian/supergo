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
    path: '/goods',
    component: Layout,
    redirect: 'noredirect',
    name: '商品管理',
    meta: {
      title: '商品管理',
      icon: 'component'
    },
    children: [
      {
        path: 'category', // 请求地址
        component: _import('demo/pages/category'), // 跳转的vue视图
        name: 'demo-category',
        meta: {title: '分类管理', icon: 'component', noCache: true}
      },
      {
        path: 'brand', // 请求地址
        component: _import('demo/pages/brand'), // 跳转的vue视图
        name: 'demo-index1',
        meta: {title: '品牌管理', icon: 'component', noCache: true}
      },
      {
        path: 'specification', // 请求地址
        component: _import('demo/pages/specification'), // 跳转的vue视图
        name: 'demo-specification',
        meta: {title: '规格管理', icon: 'component', noCache: true}
      },
      {
        path: 'type_template', // 请求地址
        component: _import('demo/pages/type_template'), // 跳转的vue视图
        name: 'type_template',
        meta: {title: '模板管理', icon: 'component', noCache: true}
      },
      {
        path: 'product_application', // 请求地址
        component: _import('demo/pages/product_application'), // 跳转的vue视图
        name: 'product_application',
        meta: {title: '产品审核', icon: 'component', noCache: true}
      },
      {
        path: 'extend_status', // 请求地址
        component: _import('demo/pages/extend_status'), // 跳转的vue视图
        name: 'extend_status',
        meta: {title: '扩展属性管理', icon: 'component', noCache: true}
      }
    ]
  }
]
