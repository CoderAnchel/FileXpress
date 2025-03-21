<script setup>
import { text } from 'motion/react-client';

const dashState = useDashboardStore();

</script>
<template>
    <div class="option">
        <div class="input inputsp">
            <img src="public/person_add_24dp_C4C4C5_FILL0_wght400_GRAD0_opsz24.svg" alt="">
            <input v-model="dashState.windows.Friends.userTo" type="text">
             <img @click="dashState.sendRequest()"  class="sender" src="public/arrow_forward_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg" alt="">
            </div>
        </div>
</template>
<style lang="scss" scoped>
   @import '@/assets/dashboard.scss';
   @import '@/assets/Account.scss';
</style>

