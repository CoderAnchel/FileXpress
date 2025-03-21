<script setup>
const dashState = useDashboardStore();

</script>
<template>
    <div class="cards">
                <UserCard v-for="user in dashState.user.friends" :key="user" :name="user.name" :user="user.username" :id="user.id" />

                <!-- DEMO MODE ⬇️ -->
               <Card v-if="dashState.demoMode" title="John Doe" subtitle="Software Engineer" img-src="/person_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg"/>
               <Card v-if="dashState.demoMode" title="Jane Doe" subtitle="Software Engineer" img-src="/person_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg"/>
               <Card v-if="dashState.demoMode" title="John Doe" subtitle="Software Engineer" img-src="/person_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg"/>
               <Card v-if="dashState.demoMode" title="Jane Doe" subtitle="Software Engineer" img-src="/person_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg"/>
               <Card v-if="dashState.demoMode" title="John Doe" subtitle="Software Engineer" img-src="/person_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg"/>
               <Card v-if="dashState.demoMode" title="Jane Doe" subtitle="Software Engineer" img-src="/person_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg"/>
               <Card v-if="dashState.demoMode" title="John Doe" subtitle="Software Engineer" img-src="/person_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg"/>
               <Card v-if="dashState.demoMode" title="Jane Doe" subtitle="Software Engineer" img-src="/person_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg"/>
               <Card v-if="dashState.demoMode" title="John Doe" subtitle="Software Engineer" img-src="/person_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg"/>
               <Card v-if="dashState.demoMode" title="Jane Doe" subtitle="Software Engineer" img-src="/person_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg"/>
               <Card v-if="dashState.demoMode" title="John Doe" subtitle="Software Engineer" img-src="/person_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg"/>
               <Card v-if="dashState.demoMode" title="Jane Doe" subtitle="Software Engineer" img-src="/person_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg"/>
               <Card v-if="dashState.demoMode" title="John Doe" subtitle="Software Engineer" img-src="/person_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg"/>
               <Card v-if="dashState.demoMode" title="Jane Doe" subtitle="Software Engineer" img-src="/person_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg"/>
               <Card  v-if="dashState.demoMode" title="John Doe" subtitle="Software Engineer" img-src="/person_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg"/>
               <Card v-if="dashState.demoMode" title="Jane Doe" subtitle="Software Engineer" img-src="/person_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg"/>
               <Card v-if="dashState.demoMode" title="John Doe" subtitle="Software Engineer" img-src="/person_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg"/>
               <Card v-if="dashState.demoMode" title="Jane Doe" subtitle="Software Engineer" img-src="/person_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg"/>
               <Card v-if="dashState.demoMode" title="John Doe" subtitle="Software Engineer" img-src="/person_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg"/>
               <Card v-if="dashState.demoMode" title="Jane Doe" subtitle="Software Engineer" img-src="/person_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg"/>
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
