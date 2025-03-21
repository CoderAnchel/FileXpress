<script setup>
const dashState = useDashboardStore();
import createGlobe from "cobe";

const el = ref();
const phi = ref(0);

onMounted(() => {
  const globe = createGlobe(el.value, {
    devicePixelRatio: 2,
    width: 300 * 2,
    height: 300 * 2,
    phi: 0,
    theta: 0,
    dark: 1,
    diffuse: 1.2,
    mapSamples: 16000,
    mapBrightness: 6,
    baseColor: [0.3, 0.3, 0.3],
    markerColor: [0.1, 0.8, 1],
    glowColor: [1, 1, 1],
    markers: [
      // longitude latitude
      { location: [37.7595, -122.4367], size: 0.03 },
      { location: [40.7128, -74.006], size: 0.1 },
    ],
    onRender: (state) => {
      // Called on every animation frame.
      // `state` will be an empty object, return updated params.
      state.phi = phi.value;
      phi.value += 0.01;
    },
  });
});
</script>
<template>
    <div class="container">
        <div class="map-container">
            <canvas :style="{ width: '400px', height: '400px' }" ref="el"></canvas>
        </div>
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

.container {
    height: 75%;
    display: flex;
    justify-content: center;

    .map-container {
        height: 300px;
    }
}
</style>
