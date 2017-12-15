import Vue from 'vue';
import Router from 'vue-router';
import config from './config';

Vue.use(Router);
const routes = [].concat(config);
const vueRouter = new Router({
    routes,
    // mode: 'history'
});

vueRouter.beforeEach((to, from, next) => {
    next();
});

export default vueRouter;
