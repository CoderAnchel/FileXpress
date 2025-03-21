<script setup>
import TopBar from "~/components/standarTopBar.vue";
import { useDashboardStore } from "../stores/dashboardStore";
import FilesCards from "~/components/Files/FilesCards.vue";
import World from "~/components/World/World.vue";

const dashState = useDashboardStore();

definePageMeta({
  middleware: "auth", // Nombre del middleware que se encuentra en /middleware/auth.ts
});

useHead({
  title: "FileXpress Dashboard",
  meta: [
    {
      name: "description",
      content: "Descripción de la página de FileXpress",
    },
  ],
});

onMounted(async () => {
  console.log("Dashboard mounted");
  dashState.loadBasicUser();
  await dashState.userFriends();
  dashState.userRequests();
  dashState.getChats();
  dashState.initializeConnection();
});

onBeforeUnmount(() => {
  if (dashState.messagues.selectedChat !== null) {
    dashState.disconnectFromChat();
  }
  dashState.closeConnection();
});
</script>
<template>
  <div class="main">
    <Messagues />
    <SideBar />
    <div class="content">
      <Header />
      <TopBar
        v-if="!dashState.windows.Settings.active"
        :title="dashState.selectedWindow"
        icon-src="/group_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg"
      />

      <transition name="fade" mode="out-in">
        <Cards
          v-if="
            dashState.windows.Friends.active &&
            !dashState.windows.Friends.windows.request
          "
        />
      </transition>

      <transition name="fade" mode="out-in">
        <RequestCards
          v-if="
            dashState.windows.Friends.active &&
            dashState.windows.Friends.windows.request
          "
        />
      </transition>

      <Settings v-if="dashState.windows.Settings.active" />

      <transition name="fade" mode="out-in">
        <Search v-if="dashState.windows.Search.active" />
      </transition>

      <transition name="fade" mode="out-in">
        <Overview v-if="dashState.windows.Overview.active" />
      </transition>

      <transition name="fade" mode="out-in">
        <FilesCards v-if="dashState.windows.MyFiles.active" />
      </transition>

      <transition name="fade" mode="out-in">
        <World v-if="dashState.windows.World.active" />
      </transition>

    </div>
  </div>
</template>
<style lang="scss" scoped>
@import "@/assets/dashboard.scss";

.fade-enter-active {
  transition: opacity 0.5s ease;
}
.fade-enter-from {
  opacity: 0;
}

// .fade-leave-active {
//   transition: none; /* Deshabilita la transición de salida */
// }
// .fade-leave-to {
//   opacity: 1; /* Asegúrate de que el componente de salida no tenga cambios de opacidad */
// }

.page-enter-active,
.page-leave-active {
  transition: all 0.4s;
}
.page-enter-from,
.page-leave-to {
  opacity: 0;
  filter: blur(1rem);
}
</style>
