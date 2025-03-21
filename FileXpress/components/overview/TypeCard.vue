<script setup>
defineProps({
  title: String,
  iconSrc: String,
  color: String,
});

const dashState = useDashboardStore();
</script>
<template>
  <div class="typeCard">
    <div class="cardHeader">
      <img
        :style="{ background: color }"
        :src="iconSrc"
        alt=""
      />
      <div class="type">
        <h3>{{ title  }}</h3>
        <p>150 items</p>
      </div>
    </div>
    <div class="card-body">
      <div class="bar">
        <div class="percentage" :style="{ background: color }"></div>
      </div>
      <span>24 GB of 100GB</span>
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

.row1 {
  h2 {
    margin: 0;
    padding: 0;
    font-size: 20px;
    margin-bottom: 15px;
  }
}

.overview {
  padding: 0;
  margin: 0;
  padding: 0 60px;
}

.cardWrapp {
  display: flex;
  justify-content: space-between;
  gap: 20px;
}

.typeCard {
  width: 23%;
  background: #191c1e;
  box-sizing: border-box;
  padding: 13px;
  border-radius: 5px;
}

.cardHeader {
  display: flex;
  align-items: center;
  margin-bottom: 15px;

  img {
    width: 30px;
    height: 30px;
    margin-right: 15px;
    background: $red;
    padding: 5px;
    border-radius: 5px;

    &:hover {
      cursor: pointer;
    }
  }

  .type {
    h3 {
      margin: 0;
      padding: 0;
      font-weight: 500;
      font-size: 16px;

        &:hover {
            cursor: pointer;
        }
    }

    p {
      margin: 0;
      padding: 0;
      color: $light-gray;
      font-size: 13px;
      margin-top: 5px;
    }
  }
}

.bar {
  width: 100%;
  height: 7px;
  background: $card-bg;
  border-radius: 5px;

  .percentage {
    width: 70%;
    height: 100%;
    background: $orange;
    border-radius: 5px;
  }
}

.card-body {
  .bar {
    margin-bottom: 5px;
  }

  span {
    color: $light-gray;
    font-size: 13px;
  }
}
</style>
