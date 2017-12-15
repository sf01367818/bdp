<template>
    <div class="footer-btns">
        <div @click="$router.push('/SenderInfo')">立即参与</div>
        <i class="iconfont icon-guanwangicon31333"></i>
    </div>
</template>
<script>
export default {
  methods: {
  },
};
</script>

<style lang="scss" scoped>
  .footer-btns{
    position: fixed;
    width: 100%;
    left: 0;
    bottom: 0;
    height: 1.066667rem /* 80/75 */;
    .iconfont{
      display: block;
      position: absolute;
      right: 0;
      top: 0;
      width: 1.333333rem /* 100/75 */;
      height: 100%;
      font-size:$bigBannerFS;
      line-height: 1.066667rem /* 80/75 */;
      text-align: center;
      color: $mcolor;
      background: $bga;
    }
    div{
      padding-right:1.333333rem /* 100/75 */;
      height: 100%;
      display: flex;
      justify-content: center;
      align-items: center;
      background: $mcolor;
      color: #ffffff;
      &:hover{
        background: $btnBg;
      }
    }
  }
</style>
