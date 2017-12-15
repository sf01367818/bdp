<template>
    <div class="wx-page">
        <head-nav title="顺丰集货助手" :type="1"></head-nav>
        <banner :bannerTitle="bannerTitle"></banner>
        <main-wrap :data='mainData'></main-wrap>
    </div>
</template>
<script>
    import HeadNav from '@/views/comp/HeadNav';
    import Banner from './Banner';
    import MainWrap from './MainWrap';

    export default {
        components: {
            HeadNav,
            Banner,
            MainWrap,
        },
        data() {
            return {
                bannerTitle: '鞋服专送080901期',
                mainData: {
                    minW: 1,
                    maxW: 1.5,
                    minNum: 20,
                },
            };
        },
    };
</script>
<style lang="scss" scoped>
    .wx-page {
        .banner {
            padding-top: 1.066667rem/* 80/75 */
            ;
        }
        .latest-add {
            padding-bottom: 1.066667rem/* 80/75 */
            ;
        }
    }
</style>