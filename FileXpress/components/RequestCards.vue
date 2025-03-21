<script setup>
const dashState = useDashboardStore();

</script>
<template>
    <div class="cards">
        <RequestCard  v-for="req in dashState.user.requests" :key="req" :name="req.name" :user="req.username" :req-i-d="req.requestId"/>
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

   .notis {
         color: $light-gray;
         font-size: 20px;
         margin-top: 20px;
   }

</style>
