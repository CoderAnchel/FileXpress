<script setup>
defineProps({
  name: String,
  msg: String,
  time: String,
});

import { time } from "motion";
import { useDashboardStore } from "../stores/dashboardStore";

const dashState = useDashboardStore();
</script>
<template>
  <div class="chat">
    <div class="info">
      <div>
        <img src="public/LogoOOD.svg" alt="" />
      </div>
      <div class="text">
        <h4>{{ name  }}</h4>
        <p>{{ msg  }}</p>
      </div>
    </div>
    <div class="options">
      <p>12:00</p>
      <img
        src="public/more_horiz_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg"
        alt=""
      />
    </div>
  </div>
</template>
<style lang="scss" scoped>
@import "@/assets/dashboard.scss";
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
