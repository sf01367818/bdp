<template>
    <div class="banner">
        <div class="banner-title">
            <div class="left-div"></div>
            <div class="title">
                {{bannerTitle}}
            </div>
            <div class="right-div"></div>
        </div>
    </div>
</template>
<script>
    export default {
        props: {
            bannerTitle: {
                type: String,
                default() {
                    return '鞋服专送080901期';
                },
            },
        },
        methods: {
        },
        data() {
            return {

            };
        },
    };
</script>
<style lang="scss" scoped>
    .banner {
        .banner-title {
            display: flex;
            justify-content: space-around;
            align-items: center;
            height: 1.333333rem/* 100/75 */
            ;
            .title {
                font-size: $bigBannerFS;
                color: $mcolor;
            }
            .left-div,
            .right-div {
                width: 2rem/* 150/75 */
                ;
                height: .066667rem/* 5/75 */
                ;
            }
            .left-div {
                background-image: linear-gradient(to left, $mcolor, #ffffff)
            }
            .right-div {
                background-image: linear-gradient(to right, $mcolor, #ffffff)
            }
        }
        border: 1px solid $divLine;
    }
</style>