<script setup>
import { useDashboardStore } from '../stores/dashboardStore'

const dashState = useDashboardStore();

</script>
<template>
    <div class="headerM">
        <h3>Chats</h3>
        <div>
            <img @click="dashState.toggleInternMessaguesWindow('Start')"  class="adderspec" src="public/add_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24 (1).svg" alt="">
            <img class="arrows" src="public/stat_2_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
        </div>
    </div>
</template>
<style lang="scss" scoped>
   @import '@/assets/dashboard.scss';
   $background-color: #101010;
   $basic-text-color: #dbdcdc;
   $red: #ff4646;
   $blue: #2970ff;
   $green: #40cd64;
   $yellow: #f3cc30;
   $orange: #e86114;
   $light-gray: #c4c4c5;
   $card-bg: #27292d;
   $links: #ababab;
   $team: #2a2524;

   .adderspec:hover {
        cursor: pointer;
   }
</style>
