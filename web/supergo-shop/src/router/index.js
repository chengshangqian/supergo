import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },

  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    redirect: '/home',
    children: [{
      path: 'home',
      name: 'Home',
      component: () => import('@/views/home/index'),
      meta: { title: '首页', icon: 'dashboard' }
    }]
  },

  {
    path: '/example',
    component: Layout,
    redirect: '/example/table',
    name: 'Example',
    meta: { title: '商品管理', icon: 'example' },
    children: [
      {
        path: 'table',
        name: 'Table',
        component: () => import('@/views/table/index'),
        meta: { title: '新建产品', icon: 'table' }
      },
      {
        path: 'tree',
        name: 'Tree',
        component: () => import('@/views/tree/index'),
        meta: { title: '产品管理', icon: 'tree' }
      },
      {
        path: 'editProduct/:id',
        name: 'editProduct',
        component: () => import('@/views/editProduct/index'),
        meta: { title: '修改产品' },
        hidden:true
      },
      {
        path: 'table2',
        name: 'Table2',
        component: () => import('@/views/table2/index'),
        meta: { title: '新增商品', icon: 'table' }
      },
      {
        path: 'tree2',
        name: 'Tree2',
        component: () => import('@/views/tree2/index'),
        meta: { title: '商品管理', icon: 'tree' }
      }
    ]
  },

  {
    path: '/order',
    component: Layout,
    name:'order',
    meta:{title:'订单管理',icon:'form'},
    children: [
      {
        path: 'orderManagement',
        name: 'Form',
        component: () => import('@/views/order/orderManagement/index'),
        meta: { title: '订单管理', icon: 'form' }
      },
      {
        path: 'tree', 
        name: 'Tree',
        component: () => import('@/views/tree/index'),
        meta: { title: '订单退货管理', icon: 'tree' }
      },
      {
        path: 'table2',
        name: 'Table2',
        component: () => import('@/views/table2/index'),
        meta: { title: '订单换货管理', icon: 'table' }
      },
      {
        path: 'tree2',
        name: 'Tree2',
        component: () => import('@/views/tree2/index'),
        meta: { title: '退货单管理', icon: 'tree' }
      }
    ]
  },

  {
    path: '/nested',
    component: Layout,
    redirect: '/nested/menu1',
    name: 'Nested',
    meta: {
      title: '系统管理',
      icon: 'nested'
    },
    children: [
      {
        path: 'menu1',
        component: () => import('@/views/nested/menu1/index'), // Parent router-view
        name: 'Menu1',
        meta: { title: '用户管理' },
      },
      {
        path: 'menu2',
        component: () => import('@/views/nested/menu2/index'),
        meta: { title: '角色管理' }
      },
      {
        path: 'menu3',
        component: () => import('@/views/nested/menu3/index'),
        meta: { title: '权限管理' }
      }
    ]
  },
  {
    path: '/about',
    component: Layout,
    redirect: '/infochange',
    name: 'info',
    meta: {
      title: '基本管理',
      icon: 'nested'
    },
    children: [
      {
        path: 'menu1',
        component: () => import('@/views/nested/menu1/index'), // Parent router-view
        name: 'Menu1',
        meta: { title: '修改资料' },
      },
      {
        path: 'menu4',
        component: () => import('@/views/nested/menu4/index'),
        meta: { title: '修改密码' }
      }
    ]
  },
  {
    path: '/demo',
    component: Layout,
    redirect: '/demo',
    name: 'demo',
    children:[{
      path: '/demo',
      component: () => import('@/views/demo/index'),
      meta: { title: '测试' }
    }]
  },
  {
    path: 'external-link',
    component: Layout,
    children: [
      {
        path: 'https://panjiachen.github.io/vue-element-admin-site/#/',
        meta: { title: 'External Link', icon: 'link' }
      }
    ]
  },

  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
