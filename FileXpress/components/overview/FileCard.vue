<script setup>
defineProps({
  title: String,
  iconSrc: String,
  color: String,
  fileType: String
});
const dashState = useDashboardStore();
</script>
<template>
  <div class="fileCard">
    <div class="fileCardHeader">
      <img src="public/Captura de pantalla 2025-01-23 a las 16.35.01.png" alt="" />
    </div>
    <div class="fileCardBottom">
      <div class="left">
        <img
          src="public/docs_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg"
          alt=""
        />
        <span>{{ title }}.{{fileType}}</span>
      </div>
      <img
        class="dots"
        src="public/more_horiz_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24 (1).svg"
        alt=""
      />
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

.fileCard {
  width: 23%;
  background: #191c1e;
  box-sizing: border-box;
  border-radius: 5px;

  .fileCardHeader {
    height: 150px;
    background: #27292d;
    border-radius: 5px;
    display: flex;
    justify-content: center;
    align-items: flex-end;
    img {
      width: 90%;
      height: 80%;
      object-fit: cover;
      border-top-left-radius: 5px;
      border-top-right-radius: 5px;
      object-position: top;

        &:hover {
            cursor: pointer;
        }
    }
  }

  .fileCardBottom {
    background: #161616;
    display: flex;
    justify-content: space-between;
    padding: 7px 12px;

    .left {
      display: flex;
      align-items: center;
      gap: 10px;

      img {
        width: 20px;
        height: 20px;
      }

      span {
        color: $light-gray;
        font-size: 14px;

        &:hover {
          color: white;
          cursor: pointer;
        }
      }
    }
  }
}

.row1 {
  margin-bottom: 30px;
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
  }

  .type {
    h3 {
      margin: 0;
      padding: 0;
      font-weight: 500;
      font-size: 16px;
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
.dots {
    &:hover {
        rotate: 360deg;
        transition: all 0.5s;
        cursor: pointer;
    }
}
</style>
