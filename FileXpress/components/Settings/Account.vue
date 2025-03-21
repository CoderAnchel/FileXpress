<script setup>
import { useDashboardStore } from '../stores/dashboardStore'
import Toggle from '@vueform/toggle'

const dashState = useDashboardStore();

const isActive = ref(false);

// Función de toggle para cambiar el valor
const toggle = () => {
  isActive.value = !isActive.value;
};

</script>
<template>
    <div class="Account">
        <div class="row1">
            <div class="col1">
                <div class="option">
                    <span>Full Name</span>
                    <div class="input">
                        <img src="public/badge_24dp_ABABAB_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                        <input @keydown.enter="dashState.modify('name')" v-model="dashState.windows.Settings.name" type="text" :placeholder="dashState.user.basic.name">
                        <img @click="dashState.modify('name')" class="sender" src="public/arrow_forward_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                    </div>
                </div>
                <div class="option">
                    <span>Username</span>
                    <div class="input">
                        <img src="public/account_circle_24dp_ABABAB_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                        <input  @keydown.enter="dashState.modify('username')" v-model="dashState.windows.Settings.username" type="text" :placeholder="dashState.user.basic.username">
                        <img @click="dashState.modify('username')"  class="sender" src="public/arrow_forward_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                    </div>
                </div>
                <div class="option">
                    <span>Email</span>
                    <div class="input">
                        <img src="public/mail_24dp_ABABAB_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                        <input @keydown.enter="dashState.modify('email')" v-model="dashState.windows.Settings.email" type="text" :placeholder="dashState.user.basic.email">
                        <img @click="dashState.modify('email')" class="sender" src="public/arrow_forward_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                    </div>
                </div>
                <div class="option">
                    <span>Phone</span>
                    <div class="input">
                        <img src="public/smartphone_24dp_ABABAB_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                        <input @keydown.enter="dashState.modify('phone')"  v-model="dashState.windows.Settings.phone" type="text" :placeholder="dashState.user.basic.phone" >
                        <img @click="dashState.modify('phone')"  class="sender" src="public/arrow_forward_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                    </div>
                </div>
                <div class="option">
                    <span>Bio</span>
                    <div class="input area">

                        <textarea @keydown.enter="dashState.modify('bio')" v-model="dashState.windows.Settings.bio" class="bio" maxlength="148" :placeholder="dashState.user.basic.bio"></textarea>
                        <img @click="dashState.modify('bio')"  class="sender" src="public/arrow_forward_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                    </div>
                </div>
            </div>
            <div class="col2">

                <div class="pfpCard">
                    <button>Change</button>
                    <div class="pfp">

                    </div>
                    <h1>{{ dashState.user.basic['name']  }}</h1>
                    <h4>@{{ dashState.user.basic.username  }}</h4>
                    <span class="tel">{{ dashState.user.basic.phone  }}</span>
                    <span>{{ dashState.user.basic.email  }}</span>
                    <p>{{ dashState.user.basic.bio  }}</p>
                </div>
            </div>
        </div>
        <h2>Change Password</h2>
        <div class="row2">
            <div class="option">
                <span>Actual</span>
                <div class="input">
                    <img src="public/lock_24dp_ABABAB_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                    <input type="password" >
                </div>
            </div>
            <div class="option">
                <span>New</span>
                <div class="input">
                    <img src="public/lock_24dp_ABABAB_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                    <input type="password" >
                </div>
            </div>
            <img class="sender" src="public/arrow_forward_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg" alt="">
        </div>
    </div>
</template>
<style lang="scss" scoped>
   @import '@/assets/dashboard.scss';
   @import '@/assets/Account.scss';
</style>
