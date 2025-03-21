<script setup>
import { useDashboardStore } from '../stores/dashboardStore'

const dashState = useDashboardStore();

</script>
<template>
    <div class="headerM">
        <div class="headerS">
            <img @click="dashState.toggleInternMessaguesWindow('Main')"  class="adderspec" src="public/arrow_back_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24 (1).svg" alt="">
            <h3>Start</h3>
        </div>
        <img class="arrows" src="public/stat_2_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
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

   .headerS {
        display: flex;
        align-items: center;
        gap: 10px;
        img {
            width: 20px;
            height: 20px;
        }
        h3 {
            font-size: 20px;
        }
   }
</style>
