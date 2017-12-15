# sf-webpack
>安装sass的方法
>npm config set registry http://nexus.sf-express.com/nexus/content/repositories/npm/ -g

>npm config set sass_binary_site http://cdn.npm.taobao.org/dist/node-sass -g

>npm install --no-optional

>全局使用ES6语法编写，SASS(预编译),postcss(后编译),集成express开发服务器(解决前台跨域问题);

>主要布局模式 app.vue views/main/index.vue||latout.vue;

>集成sass(assets/common.scss 存放全局变量),全局样式(assets/style.scss)（修改element样式）;

>集成http.js(axios拦截器) 实现统一登录，统一出错处理;

>集成vue-router(实现权限路由钩子);

>集成vuex 全局状态管理（模块global处理全局状态）;

>集成es-lint(基于airbnb模板) 管理代码规范;

>基于element2.x 封装成业务组件sfsFilter,leftMenu,sfTable...后续增加公用组件;

>测试相关(karma-mocha,selenium-server)
> sf-webpack

## Build Setup

``` bash
# install dependencies
npm install

# serve with hot reload at localhost:8080
npm run dev

# build for production with minification
npm run build

# build for production and view the bundle analyzer report
npm run build --report

# run unit tests
npm run unit

# run e2e tests
npm run e2e

# run all tests
npm test
```

For a detailed explanation on how things work, check out the [guide](http://vuejs-templates.github.io/webpack/) and [docs for vue-loader](http://vuejs.github.io/vue-loader).
