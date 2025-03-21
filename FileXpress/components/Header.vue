<script setup>
import { useDashboardStore } from '../stores/dashboardStore'

const dashState = useDashboardStore();

</script>
<template>
         <div class="header navbar">
            <div class="first">
               <h3>File Manager</h3>
               <div class="input">
                  <img class="clickable" src="public/search_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                    <input v-if="!dashState.windows.Friends.active && !dashState.windows.Search.active" type="text" placeholder="Search for Files">
                  <input v-model="dashState.searchData.value"  v-if="dashState.windows.Friends.active || dashState.windows.Search.active" type="text" placeholder="Search Friends" @keyup.enter="dashState.searchUser()">
                  <div style="display: flex; width: 15%; justify-content: space-between;">
                     <span class="composed-span"><img src="public/keyboard_command_key_24dp_000000_FILL0_wght400_GRAD0_opsz24.svg" alt=""> + K</span>
                     <img class="clickable" src="public/discover_tune_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                  </div>
               </div>
            </div>
            <div class="nav-links">
               <img  @click="dashState.toggleWindow('World')" class="clickable" src="public/travel_explore_24dp_D9D9D9_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                  <img class="clickable" src="public/info_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                  <img class="clickable notis" src="public/notifications_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                  <img @click="dashState.toggleWindow('Settings')" class="clickable setti" src="public/settings_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                  <div class="icon">

                  </div>
            </div>
            <div class="second">
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
</style>
