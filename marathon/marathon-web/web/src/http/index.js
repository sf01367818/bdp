import axios from 'axios';

axios.defaults.timeout = 60000;

// http request 拦截器
// axios.defaults.baseURL = 'http://localhost:8083/';
axios.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
axios.defaults.headers.common['Content-Type'] = 'application/x-www-form-urlencoded; charset=UTF-8';
axios.interceptors.request.use(
    (config) => {
        // if(store.state.global.userToken){
        //   // config.Authorization = `token ${store.state.currentUser.userToken}`;
        //   config.headers["access-token"] = store.state.currentUser.userToken;
        // }
        config.transformRequest = [function (data) {
            let ret = '';
            let upload = false;
            if (data) {
                Object.keys(data).forEach((k) => {
                    if (data[k] instanceof File) upload = true;
                }, this);
            }
            if (upload) {
                axios.defaults.headers.common['Content-Type'] = 'multipart/form-data';
                ret = new FormData();
                Object.entries(data).forEach((en) => {
                    ret.append(en[0], en[1]);
                });
            } else {
                if (data) {
                    Object.keys(data).forEach((key) => {
                        let value = '';
                        if (typeof data[key] === 'object') {
                            value = JSON.stringify(data[key]);
                        } else {
                            value = data[key];
                        }
                        ret += `${encodeURIComponent(key)}=${encodeURIComponent(value)}&`;
                    });
                }
                ret = ret.substr(0, ret.length - 1);
            }
            return ret;
        }];
        return config;
    },
    err => Promise.reject(err));

// 401 302 code!=0 拦截处理;
axios.interceptors.response.use(
    (res) => {
        // if (res.data.code == 401) {
        //     router.replace({
        //         path: '401'
        //     })
        // }
        // store.commit('IS_LOADING', false);
        if (res.data.status === 302) {
            // localStorage.setItem("logout",res.data.redirect);
        }
        if (res.data.status !== 0) {
            if (res.data.msg) {
                // util.createMessage({
                //     type: 'error',
                //     message: res.data.msg
                // });
                return res;
            }
        }
        return res;
    },
    (error) => {
        if (error.response) {
            // switch (error.response.status) {
            //     case 401:
            //         store.commit("clearUser");
            //         router.replace({
            //             path: 'signIn',
            //             query: { redirect: router.currentRoute.fullPath }
            //         })
            // }
        }
        return Promise.reject(error.response);
    });
export default axios;
