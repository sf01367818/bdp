// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue';
import '@/assets/style.scss';
import App from './App';
import router from './router';
import store from './store';
import axios from './http';

Vue.config.errorHandler = function (err, vm) {
    console.log('error', err, vm);
};

Vue.config.productionTip = false;
Vue.prototype.axios = axios;

/* eslint-disable no-new */
new Vue({
    el: '#app',
    router,
    store,
    template: '<App/>',
    components: {
        App,
    },
});
