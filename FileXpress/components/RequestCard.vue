<script setup>
const props = defineProps({
    name: String,
    user: String,
    reqID: String
});

const dashState = useDashboardStore();

</script>
<template>
    <div class="card">
        <img class="options" src="public/more_horiz_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
        <div class="header">
            <img src="public/LogoOOD.svg" alt="">
        </div>
        <div class="content">
            <h2>{{ name  }}</h2>
            <p>@{{ user  }}</p>
            <div class="buttons">
                <button @click="dashState.acceptFriend(reqID)" class="spec">Accept</button>
                <button>Decline</button>
            </div>
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

   .options {
        position: relative;
        top: 10px;
        right: -212px;
        margin: 0;
        width: 18px;
        height: 18px;
        cursor: pointer;

        &:hover {
            rotate: 360deg;
            transition: all 0.5s;
        }
    }

   @font-face {
        font-family: 'Virgil';
        src: url('assets/Virgil.woff2') format('woff2');
        font-weight: normal;
        font-style: normal;
    }

    .card {
        background-color: $background-color;
        border-radius: 18px;
        margin: 20px;
        width: 240px;
        height: 330px;
        display: flex;
        flex-direction: column;
        // font-family: "Virgil";
        font-weight: 100;
        border: 2px solid $card-bg !important;
    }

    .header {
        height: 30%;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        padding: 20px;
        margin: 0;
        border-bottom: 2px solid $card-bg !important;

        img {
            display: flex;
            justify-content: center;
            align-items: center;
            width: 100px;
            height: 100px;
            margin: 0;
        }
    }

    .content {
        display: flex;
        flex-direction: column;
        padding: 20px;
        height: 50%;
        margin: 0;
        text-align: center;
        justify-content: space-between;

        h2 {
            color: #dbdcdc;
            font-size: 1.2rem;
            margin: 0;
        }

        p {
            margin-top: 5px;
            margin-bottom: 13px 0;
        }

        .buttons {
            display: flex;
            justify-content: space-between;
            gap: 10px;

            button {
                display: flex;
                justify-content: center;
                background: #2a2524;
                color: #dbdcdc;
                border: none;
                padding: 10px 25px;
                width: 50%;
                font-size: 1rem;
                cursor: pointer;
                border: 1px solid $orange;
                border-radius: 10px;
                color: $orange;

                &:hover {
                    background: $orange;
                    color: $basic-text-color;
                    transition: all 0.3s;
                }
            }

            .spec {
                display: flex;
                justify-content: center;
                background: $orange;
                color: $basic-text-color;

                &:hover {
                    background: darken($orange, 10%);
                }
            }
        }
    }
</style>
