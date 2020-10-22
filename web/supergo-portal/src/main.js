// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from "vue";
import App from "./App";
import router from "./router";
// 引入axios
import axios from "axios";
//引入store
import store from "./store";
// 全局引入jquery
import $ from "jquery";
//引入element-ui库并使用
import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";
Vue.use(ElementUI);

// 将axios挂载在Vue原型
Vue.prototype.$axios = axios;
Vue.prototype.$bus = new Vue();
// 跳转后返回顶部
router.afterEach((to, from, next) => {
  window.scrollTo(0, 0);
});

Vue.config.productionTip = false;

/* eslint-disable no-new */
new Vue({
  el: "#app",
  router,
  store,
  components: { App },
  template: "<App/>"
});
