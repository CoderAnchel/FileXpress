<script setup>
import { useDashboardStore } from '../stores/dashboardStore'

const dashState = useDashboardStore();

</script>
<template>
      <div class="sidebar">
         <div class="header">
            <h1 id="logo"><img src="public/logo-FileXpress.svg" alt=""> FileXpress</h1>
         </div>
         <div class="router">
            <h4>Overview</h4>
            <div class="route clickable spec" :class="{active: dashState.windows.Overview.active}"
            @click="dashState.toggleWindow('Overview')
            ">
               <img src="public/grid_view_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg" alt="">
               <span>Overview Storage</span>
            </div>
            <div class="route clickable spec"
            :class="{active: dashState.windows.Friends.active}"
            @click="dashState.toggleWindow('Friends')
            ">
               <img src="public/group_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg" alt="">
               <span>Friends</span>
            </div>
         </div>
         <div class="router">
            <h4>File Manager</h4>
            <div class="selection clickable" @click="dashState.toggleWindow('MyFiles')">
               <div class="fix">
                  <img :class="{down: dashState.windows.MyFiles.active}"  class="caret" src="public/arrow_forward_ios_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                  <img src="public/cloud_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                  <span>My Files</span>
               </div>
            </div>
            <div class="selection clickable" @click="dashState.toggleWindow('RecentFiles')">
               <div class="fix">
                  <img :class="{down: dashState.windows.RecentFiles.active}"  class="caret" src="public/arrow_forward_ios_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                  <img src="public/schedule_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                  <span>Recent</span>
               </div>
               <div v-if="dashState.windows.RecentFiles.notis > 0"  class="notification">
                  <span>{{ dashState.windows.RecentFiles.notis  }}</span>
               </div>
            </div>
            <div class="selection clickable" @click="dashState.toggleWindow('Favorites')">
               <div class="fix">
                  <img :class="{down: dashState.windows.Favorites.active}"  class="caret" src="public/arrow_forward_ios_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                  <img src="public/star_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                  <span>Favorites</span>
               </div>
               <div v-if="dashState.windows.Favorites.notis > 0" class="notification">
                  <span>{{ dashState.windows.Favorites.notis  }}</span>
               </div>
            </div>
            <div class="selection clickable" @click="dashState.toggleWindow('Trash')">
               <div class="fix">
                  <img :class="{down: dashState.windows.Trash.active}" class="caret" src="public/arrow_forward_ios_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                  <img src="public/delete_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                  <span>Trash</span>
               </div>
            </div>
         </div>
         <div class="router">
            <h4>Shared File</h4>
            <div class="selection clickable special" @click="dashState.toggleWindow('SharedFolder')">
               <div class="fix">
                  <img :class="{down: dashState.windows.SharedFolder.active}" class="caret" src="public/arrow_forward_ios_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                  <img src="public/cloud_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                  <span>Shared Folder</span>
               </div>

            </div>
            <div class="selection clickable" @click="dashState.toggleWindow('SharedFiles')">
               <div class="fix">
                  <img :class="{down: dashState.windows.SharedFiles.active}" class="caret" src="public/arrow_forward_ios_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                  <img src="public/schedule_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                  <span>Shared File</span>
               </div>

            </div>
         </div>
         <div class="router">
            <h4>Team Storage</h4>
            <div class="selection clickable special">
               <div class="fix">
                  <img class="caret" src="public/arrow_forward_ios_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                  <img src="public/groups_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                  <span>Team 1</span>
               </div>

            </div>
            <div class="selection clickable">
               <div class="fix">
                  <img class="caret" src="public/arrow_forward_ios_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                  <img src="public/groups_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                  <span>Software Team</span>
               </div>
            </div>
            <button class="btn"><img src="public/add_24dp_F56614_FILL0_wght400_GRAD0_opsz24.svg" alt=""> Add team storage</button>
         </div>
         <div class="router">
            <div style="display: flex; justify-content: space-between;">
               <h4 style="display: flex; align-items: center;"><img src="public/folder_open_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt=""> Storage</h4>
               <h4>92%</h4>
            </div>
            <div class="bar">
               <div class="percentage"></div>
            </div>
            <button class="btn specBtn">Upgrade Plan</button>
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

   .active {
      transition: all 0.3s;
      background: $orange !important;
   }

   .down {
      rotate: 90deg;
   }

</style>
