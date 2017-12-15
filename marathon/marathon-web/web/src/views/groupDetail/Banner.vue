<template>
    <div class="banner">
        <div class="banner-title">
            <div class="left-div"></div>
            <div class="title">
                {{data.title}}
            </div>
            <div class="right-div"></div>
        </div>
        <div class="banner-wrap">
            <div class="details">
                {{`${data.minW}-${data.maxW}kg 每日最低寄件`}}
                <span>{{data.minNum}}</span>件
            </div>
            <img :src="data.bannerUrl" :alt="data.title">
            <div class="stamp">
                <img src="static/image/group-stamp.png" alt="">
                <div class="price">
                    <span>低至￥
                        <span>{{data.price}}</span>
                    </span>
                    <span>1.5kg</span>
                </div>
            </div>
            <div class="count">
                <img src="static/image/range.png" alt="">
                <div class="count-info">
                    还差
                    <span>{{data.leftP}}</span>人即可成团
                </div>
            </div>
            <div class="last-date">
                截止日期：{{new Date(data.deadLine).getMonth()+1}}月{{new Date(data.deadLine).getDate()}}日
            </div>
        </div>
    </div>
</template>
<script>
    export default {
        props: {
            data: {
                type: Object,
                default() {
                    return {
                        title: '鞋服专送080901期',
                        maxW: 5,
                        minW: 1.5,
                        minNum: 20,
                        needP: 100,
                        leftP: 8,
                        price: 6,
                        bannerUrl: 'static/image/banner.jpg',
                        deadLine: new Date(),
                    };
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
        .banner-wrap {
            width: 100%;
            height: auto;
            position: relative;
            .details {
                line-height: 1.333333rem/* 100/75 */
                ;
                padding: 0 .266667rem/* 20/75 */
                ;
                font-size: $textFS;
                span {
                    color: $tipText;
                }
            }
            .stamp {
                width: 20%;
                height: auto;
                position: absolute;
                right: 8%;
                top: 5%;
                img {
                    width: 100%;
                    height: 100%;
                }
                .price {
                    font-size: $smallTextFS;
                    color: $bga;
                    text-align: center;
                    position: absolute;
                    left: 0;
                    top: 0;
                    width: 100%;
                    height: 80%;
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    flex-direction: column;
                    span span {
                        font-size: $inputFS;
                    }
                }
            }
            .count {
                display: flex;
                justify-content: space-between;
                align-items: center;
                margin: 0 .266667rem/* 20/75 */
                ;
                padding: .266667rem/* 20/75 */
                0;
                border-bottom: 1px solid $divLine;
                img {
                    width: 5.333333rem/* 400/75 */
                    ;
                    height: auto;
                }
                .count-info {
                    font-size: $textFS;
                    span {
                        color: $mcolor;
                    }
                }
            }
            .last-date {
                font-size: $textFS;
                padding: .266667rem/* 20/75 */
                ;
                font-weight: bold;
            }
        }
        border: 1px solid $divLine;
    }
</style>