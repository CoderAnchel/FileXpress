<script setup>
import FindedUser from './FindedUser.vue';

const dashState = useDashboardStore();

</script>
<template>
    <div class="cards">
        <h2 v-if="dashState.searchData.loading">Search On-Going...</h2>

        <FindedUser v-for="user in dashState.searchData.data" :key="user" :name="user.name" :user="user.username" :id="user.id" :is-friend="user.isFriend" :is-me="user.isMe"/>
    </div>
</template>
<style lang="scss" scoped>
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
