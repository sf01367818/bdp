
import Vue from 'vue';
import Router from 'vue-router';
import GroupDetail from '@/views/groupDetail/Layout';
import SenderInfo from '@/views/senderInfo/Layout';
import WxPage from '@/views/WxPage/Layout';


Vue.use(Router);
export default [
{
    // 主页重定向
    path: '/',
    redirect: '/WxPage',
},
{
    // 调度平台下的数据开发页面，查看任务信息
    path: '/GroupDetail',
    name: 'GroupDetail',
    component: GroupDetail,
},
{
  // 调度平台下的数据开发页面，查看任务信息
  path: '/SenderInfo',
  name: 'SenderInfo',
  component: SenderInfo,
},
{
  // 调度平台下的数据开发页面，查看任务信息
  path: '/WxPage',
  name: 'WxPage',
  component: WxPage,
}];
