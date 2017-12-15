<template>
    <div class="head-nav">
        <div class="left-btn" v-if="type === 0">
            <i class="iconfont icon-chevron-copy-copy-copy-copy-copy-copy" @click="goBack()"></i>
            <i class="iconfont icon-guanbi1" @click="goBack()"></i>
        </div>
        <div class="title">
            {{title}}
        </div>
        <i class="right-btn iconfont icon-ellipsis" @click="getOperateDetail" v-if="type === 0"></i>
    </div>
</template>
<script>
    export default {
        props: {
            title: {
                type: String,
                default() {
                    return '集货详情';
                },
            },
            type: {
                type: Number,
                default() {
                    return 0;
                },
            },
        },
        data() {
            return {};
        },
        methods: {
            getOperateDetail() {},
            goBack() {
              history.go(-1);
            },
        },
    };
</script>
<style lang="scss">
    .head-nav {
        width: 100%;
        height: 1.066667rem/* 80/75 */
        ;
        background: $mcolor;
        font-size: $topTitleFS;
        color: $bga;
        line-height: 1.066667rem/* 80/75 */
        ;
        text-align: center;
        position: fixed;
        left: 0;
        top: 0;
        .left-btn,
        .right-btn {
            position: absolute;
            width: 2rem/* 150/75 */
            ;
            height: 100%;
            padding: .133333rem/* 10/75 */
            ;
            display: flex;
            align-items: center;
            &.iconfont,
            .iconfont {
                font-size: $smallTitleFS;
            }
        }
        .right-btn {
            right: .266667rem/* 20/75 */
            ;
            top: 0;
            justify-content: flex-end;
            padding-right: .333rem/* 20/75 */
            ;
            &.iconfont {
                font-size: 0.7rem;
            }
        }
        .left-btn {
            left: .266667rem/* 20/75 */
            ;
            top: 0;
            justify-content: space-between;
            .iconfont:last-of-type {
                font-size: 0.65rem;
            }
        }
    }
</style>