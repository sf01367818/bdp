<template>
    <div class="main-wrap">
        <div class="main-content">
            <div>
                全国流向
                <span>{{` ${data.minW}-${data.maxW}kg `}} </span> 每日承诺寄件量最低 <span>{{data.minNum}}</span> 件
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
                      minW: 1,
                      maxW: 1.5,
                      minNum: 20,
                    };
                },
            },
        },
    };
</script>
<style lang="scss" scoped>
  .main-wrap{
    .main-content{
      div{
        text-align: center;
        span{
          color: $mcolor;
          margin-right: 10px;
          padding:0 10px;
          display: inline-block;
          &:first-of-type{
            border-right: 1px solid #000;
          }

        }
      }
    }
  }
</style>