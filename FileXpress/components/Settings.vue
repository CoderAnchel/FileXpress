<script setup>
import { useDashboardStore } from '../stores/dashboardStore'
import Account from './Settings/Account.vue'

const dashState = useDashboardStore();

</script>
<template>
    <div class="settings">
        <div class="settingsHeader">
            <div style="display: flex; justify-content: space-between;">
                <h1>Settings</h1>
                <img class="dots" src="public/more_horiz_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
            </div>
            <div class="SettingsOps">
                <button @click="dashState.toggleInternSettingsWindow('Account')" :class="{selected: dashState.windows.Settings.ownWindows.Account.active}" class="btn">Account</button>
                <button @click="dashState.toggleInternSettingsWindow('Privacy')" :class="{selected: dashState.windows.Settings.ownWindows.Privacy.active}" class="btn">Privacy</button>
                <button @click="dashState.toggleInternSettingsWindow('Apparence')" :class="{selected: dashState.windows.Settings.ownWindows.Apparence.active}"  class="btn">Apparence</button>
                <button @click="dashState.toggleInternSettingsWindow('Notifications')" :class="{selected: dashState.windows.Settings.ownWindows.Notifications.active}"  class="btn">Notifications</button>
                <button @click="dashState.toggleInternSettingsWindow('Security')"  :class="{selected: dashState.windows.Settings.ownWindows.Security.active}"  class="btn">Security</button>
                <button @click="dashState.logOut()" class="btn red">Log Out</button>
            </div>
        </div>
        <div class="content">
            <Account v-if="dashState.windows.Settings.ownWindows.Account.active"/>
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

    .content {
        display: flex;
        flex-direction: column;
        width: 100%;
        color: $basic-text-color;
        height: 80%;
        overflow-y: auto;
        max-width: 1600px;
    }

   .settings {
       display: flex;
       flex-direction: column;
       height: 80%;
       width: 100%;
       color: $basic-text-color;


       .dots {
        position: relative;
        right: 20px;
        &:hover {
            rotate: 360deg;
            transition: all 0.5s;
        }
       }

       .settingsHeader {
        height: 133px;
        padding: 25px;
        border-bottom: 2px solid $card-bg;
       }

       .SettingsOps {
        display: flex;
            .btn {
                margin-right: 10px;
                border: none;
                background-color: $background-color;
                color: $basic-text-color;
                padding: 10px;
                font-size: 15px;
                cursor: pointer;
                border-radius: 10px;
                font-weight: 500 !important;
                border: 2px solid $background-color;
            }

            .btn:hover {
                background-color: $card-bg;
                color: $basic-text-color;
                border-radius: 10px;
                transition: all 0.3s;
            }

            .selected {
                border: 2px solid $orange;
                background: #2a2524;
                color: $basic-text-color;
                border-radius: 10px;
            }

            .red {
                background-color: $orange;
                color: $basic-text-color;
                border-radius: 10px;

                &:hover {
                    background-color: darken($color: $red, $amount: 3);
                    color: $basic-text-color;
                    border-radius: 10px;
                }
            }
       }
   }

   .content::-webkit-scrollbar {
  width: 8px; /* Ancho de la barra de desplazamiento */
}

/* Personaliza el track (fondo de la barra de desplazamiento) */
.content::-webkit-scrollbar-track {
   background: lighten($color: $background-color, $amount: 3);/* Color del fondo del track */
  border-radius: 5px; /* Esquinas redondeadas opcionales */
  scroll-behavior: smooth;
}

/* Personaliza el thumb (la parte que se desplaza) */
.content::-webkit-scrollbar-thumb {
  background-color: #555; /* Color del thumb */
  border-radius: 5px; /* Redondeo del thumb */
  border: 2px solid $card-bg; /* Opcional: agrega un borde para mejor contraste */
}

/* Cambia el color del thumb al pasar el cursor */
.content::-webkit-scrollbar-thumb:hover {
  background-color: $orange; /* Un color más claro al hacer hover */
}
</style>
