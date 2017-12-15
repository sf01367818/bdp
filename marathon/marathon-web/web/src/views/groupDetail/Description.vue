<template>
    <div class="description">
        <div class="des-title">
            <i class="iconfont icon-msnui-alarm-circle"></i>
            <span>使用要求</span>
        </div>
        <ul v-html="useRequire">
        </ul>
    </div>
</template>
<script>
    export default {
        props: {
            useRequire: {
                type: String,
            },
        },
    };
</script>
<style lang="scss">
    .description {
        padding: .266667rem/* 20/75 */
        ;
        font-size: $smallTitleFS;
        border: 1px solid $divLine;
        .des-title {
            font-weight: bold;
            line-height: 1.333333rem/* 100/75 */
            ;
        }
        .iconfont {
            font-size: $smallTitleFS;
        }
        ul>li {
            font-size: $textFS;
            color: $grayState;
        }
    }
</style>