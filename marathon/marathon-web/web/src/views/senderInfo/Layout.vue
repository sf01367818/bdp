<template>
    <div class="sender-info">
        <head-nav title="填写寄件信息"></head-nav>
        <send-address></send-address>
        <send-num></send-num>
        <send-p></send-p>
        <footer-btn></footer-btn>
    </div>
</template>
<script>
    import HeadNav from '@/views/comp/HeadNav';
    import SendAddress from './SendAddress';
    import SendNum from './SendNum';
    import SendP from './SendP';
    import FooterBtn from './FooterBtn';

    export default {
        components: {
            HeadNav,
            SendAddress,
            SendNum,
            SendP,
            FooterBtn,
        },
    };
</script>
<style lang="scss" scoped>

</style>