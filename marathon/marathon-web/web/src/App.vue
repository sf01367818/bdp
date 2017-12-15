<template>
    <div id="app">
        <router-view></router-view>
    </div>
</template>

<script>
    export default {
        name: 'app',
    
    };
</script>

<style lang="scss">
    #app {
        font-family: "Microsoft YaHei";
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        color: #666666;
        height: 100%;
        width: 100%;
        font-size: $textFS;
    }
</style>