<template>
    <div class="group-detail">
        <head-nav title="集货详情" :type='0'></head-nav>
        <banner :data="bannerData"></banner>
        <description :useRequire="descrData"></description>
        <latest-add :data="addData"></latest-add>
        <footer-info></footer-info>
    </div>
</template>
<script>
    import HeadNav from '@/views/comp/HeadNav';
    import LatestAdd from './LatestAdd';
    import Description from './Description';
    import Banner from './Banner';
    import FooterInfo from './FooterInfo';

    export default {
        components: {
            HeadNav,
            LatestAdd,
            Description,
            Banner,
            FooterInfo,
        },
        data() {
            return {
                bannerData: {},
                descrData: '',
                addData: {},
            };
        },
        beforeCreate() {
            const self = this;
            this.axios.get('/marathon-control/group/getGroupDetail?mktId=mkt01').then((res) => {
                console.log(res);
                if (res.data.success) {
                    const data = res.data.data;
                    console.log(data);
                    const bannerData = {
                        title: data.group.groupName,
                        maxW: data.marketBase.weightMin,
                        minW: data.marketBase.weightMax,
                        minNum: data.marketBase.dailyMinPackages,
                        needP: data.marketBase.groupLimit,
                        leftP: data.marketBase.groupLimit - data.userNum,
                        price: data.marketBase.basePrice,
                        bannerUrl: 'static/image/banner.jpg',
                        deadLine: data.group.endTime,
                    };
                    const descrData = data.marketBase.useRequire;
                    const addData = {
                      userNum: data.userNum,
                    };
                    self.bannerData = bannerData;
                    self.descrData = descrData;
                    self.addData = addData;
                }
            }).catch((err) => {
                console.log(err);
            });
        },
    };
</script>
<style lang="scss" scoped>
    .group-detail {
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