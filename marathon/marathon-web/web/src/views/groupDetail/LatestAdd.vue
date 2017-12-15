<template>
    <div class="latest-add">
        <div class="add-per">
            <h3>
                <i class="iconfont icon-renqunhuaxiang-"></i>
                最近参与
            </h3>
            <div class="per-header">
                <div class="imgs clearfix">
                    <img class="fl" :src="url" alt="" v-for="(url,index) in images" :key="index">
                </div>
                <div class="per-desc">
                    已有
                    <span>{{data.userNum}}</span>人参团
                </div>
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
                  return {};
                },
            },
        },
        data() {
          return {
          };
        },
        computed: {
          images() {
            const imgs = [];
            for (let i = 0; i < this.data.userNum; i++) {
              imgs.push('static/image/1.png');
            }
            return imgs;
          },
        },
    };
</script>
<style lang="scss" scoped>
    .latest-add {
        padding: .266667rem/* 20/75 */
        ;
        h3 {
            font-size: $smallTitleFS;
            .iconfont {
                font-size: $smallTitleFS;
            }
        }
        .per-header {
            width: 100%;
            position: relative;
            .imgs {
                padding: .333333rem/* 25/75 */
                .666667rem/* 50/75 */
                ;
                img {
                    margin-left: -.266667rem/* 20/75 */
                    ;
                    width: .666667rem/* 50/75 */
                    ;
                    height: .666667rem/* 50/75 */
                    ;
                    border-radius: 50%;
                }
            }
            .per-desc {
                position: absolute;
                right: .266667rem/* 20/75 */
                ;
                top: 0;
                padding: .333333rem/* 25/75 */
                .666667rem/* 50/75 */
                ;
                span{
                  color: $tipText;
                }
            }
        }
    }
</style>