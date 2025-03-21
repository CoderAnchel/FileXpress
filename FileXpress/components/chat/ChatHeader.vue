<script setup>
import { useDashboardStore } from '../stores/dashboardStore'

const dashState = useDashboardStore();

</script>
<template>
    <div class="headerM">
        <div class="headerS">
            <img @click="dashState.toggleInternMessaguesWindow('Main')"  class="adderspec" src="public/arrow_back_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24 (1).svg" alt="">
            <div class="titleWrappers">
                <div class="title">
                    <h3>{{ dashState.messagues.selectedChat.name  }}</h3>
                    <div class="dot"></div>
                </div>
                <span>@{{  dashState.messagues.selectedChat.username }}</span>
            </div>
        </div>
        <div>
            <img class="chat-click" src="public/star_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24 (2).svg" alt="">
            <img class="chat-click" src="public/settings_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
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

   .headerS {
        display: flex;
        align-items: center;
        gap: 10px;
        img {
            width: 20px;
            height: 20px;
        }
        h3 {
            font-size: 18px;
        }
   }

   .title {
        display: flex;
        align-items: center;
        .dot {
            width: 10px;
            height: 10px;
            background: $green;
            border-radius: 50%;
            margin-left: 5px;
        }
        h3 {
            font-size: 15px !important;
            margin: 0 !important;
            padding: 0 !important;
        }
   }

   .titleWrappers {
        padding: 8px 0;
        display: flex;
        flex-direction: column;
        gap: 5px;
   }

   span {
        color: $light-gray;
        font-size: 13px;
   }

   .chat-click:hover {
        cursor: pointer;
        rotate: 365deg;
        transition: all 0.4s;
   }
</style>
