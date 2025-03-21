<script setup>
const props = defineProps({
    id: String,
    from: String,
    time: String,
    message: String,
});

const dashState = useDashboardStore();

</script>
<template>
    <div class="messague-wrapper">
        <div class="mover" :class="{'you': from == 'true'}">
            <div class="messague">
                 <p>{{ message  }}</p>
            </div>
            <span>{{ time  }}</span>
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

    .messague {
         padding: 10px;
         background-color: $card-bg;
         border-radius: 20px;
         margin: 10px 0;
         width: 45%;
         margin-left: 10px !important;

         p {
              color: $basic-text-color;
              font-size: 14px;
              line-height: 1.6;
              margin: 0;
              padding: 0;
         }
    }

    .you {
        display: flex;
        flex-direction: column;
        align-items: flex-end;
        float: right !important;
        width: 100%;

        .messague {
            background-color: $orange;
            color: $background-color;
            margin-left: 0 !important;
        }

        span {
            margin-right: 15px;
        }
    }

    span {
        color: $light-gray;
        font-size: 12px;
        margin-left: 15px;
    }

    .messague-wrapper {
        display: flex;
    }

</style>
