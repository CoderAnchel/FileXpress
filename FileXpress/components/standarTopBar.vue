<script setup>
import { useToast } from "vue-toastification";

const props = defineProps({
  title: {
    type: String,
    required: true
  },
  iconSrc: {
    type: String,
    required: true,
    default: ''
  }
})

const options = ["Request","Friends"];

const toast = useToast();
const dashState = useDashboardStore();

const toggleAddFriend = () => {
  dashState.windows.Friends.add = !dashState.windows.Friends.add;
};

const copyToClipBoard = () => {
  navigator.clipboard.writeText(dashState.user.basic.id);
  toast.success('Copied to clipboard');
}

const toggleRequest = () => {
  dashState.windows.Friends.windows.request = !dashState.windows.Friends.windows.request;

  if(dashState.windows.Friends.windows.request){
    dashState.selectedWindow = options[0];
  } else dashState.selectedWindow = options[1];
}
</script>
<template>
    <div v-if="!dashState.windows.World.active" class="TopBar">
        <InputComponent v-if="dashState.windows.Friends.add && dashState.windows.Friends.active" />

<!--
        <span v-if="!dashState.windows.Friends.add || !dashState.windows.Friends.active" class="title"><img :src="props.iconSrc" alt=""> {{ props.title }}</span> -->

        <span v-if="!dashState.windows.Friends.add || !dashState.windows.Friends.active" class="title"> </span>

        <div class="options">
            <span @click="copyToClipBoard" v-if="dashState.windows.Friends.add && dashState.windows.Friends.active" class="clickable speco"><img src="public/content_copy_24dp_C4C4C5_FILL0_wght400_GRAD0_opsz24.svg" alt="">Copy</span>
            <span class="clickable speco"><img src="public/swap_vert_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt=""> Sort</span>
            <span v-if="!dashState.windows.Friends.active" class="clickable speco"><img src="public/grid_view_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt=""> View</span>
            <span @click="toggleRequest" v-if="dashState.windows.Friends.active" class="clickable speco" :class="{spec2: dashState.windows.Friends.windows.request}"><img src="public/grid_view_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt=""> Requests</span>
            <span v-if="!dashState.windows.Search.active" @click="toggleAddFriend" class="spec clickable"><img class="add" src="public/add_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt=""> Add</span>
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

.TopBar {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 40px;
  background-color: #101010;
  color: #dbdcdc;

  .title {
    display: flex;
    align-items: center;
  }

  img {
    margin-right: 10px;
    width: 20px;
    height: 20px;
  }

  .options {
    display: flex;
    gap: 20px;

    span {
      display: flex;
      align-items: center;
      background: $card-bg;
      padding: 10px 20px;
      border-radius: 5px;
      color: $light-gray;
      font-size: 14px;

      img {
        margin-right: 10px;
        width: 20px;
        height: 20px;
      }
    }

    .spec {
      background: $orange;
      color: white;
      padding: 10px 17px;
      border-radius: 5px;

      img {
        margin-right: 3px;
      }

      &:hover {
        background: darken($orange, 10%);
        transform: all 1s;

        .add {
          rotate: 360deg;
          transition: all 0.5s;
        }
      }
    }
  }
}

  .clickable {
      cursor: pointer;
   }

  .speco:hover {
    background: lighten($color: $card-bg, $amount: 3) !important;
  }

  .spec2 {
    background: $orange !important;
    color: white;
    padding: 10px 17px;
    border-radius: 5px;

    &:hover {
      background: darken($orange, 10%) !important ;
      transform: all 1s;
    }
  }
</style>
