// Vue 的主路口 axiox 全局变量注册位置

// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

import axios from 'axios';

// import iView from 'iview';
// import 'iview/dist/styles/iview.css';
// import VueSimplemde from 'vue-simplemde';
// import 'simplemde/dist/simplemde.min.css';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

// Vue.config.productionTip = false

Vue.use(ElementUI);

// 将API方法绑定到全局
Vue.prototype.$axios = axios;
axios.defaults.withCredentials = true;

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})









