    <script setup>
    defineProps({
        name: String,
        user: String,
        id: Number
    });

    import { useDashboardStore } from '../stores/dashboardStore'

    const dashState = useDashboardStore();
    const show = ref(true);

    const handleClick = (id_to) => {
        dashState.createChat(id_to);
        show.value = false;
    }

    </script>
    <template>
        <div class="headerM" v-if="show">
            <div class="headerS">
                <div class="iconF">

                </div>
                <div>
                    <h4>{{ name  }}</h4>
                    <h5>@{{ user  }}</h5>
                </div>
            </div>
            <button @click="handleClick(id)">Add</button>
        </div>
    </template>
    <style lang="scss" scoped>
    @import '@/assets/dashboard.scss';
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

    .adderspec:hover {
            cursor: pointer;
    }


    .headerM {
        padding:  15px 25px !important;
    }

    .headerS {
            display: flex;
            align-items: center;
            gap: 10px;
            img {
                width: 20px;
                height: 20px;
            }
            h3 {
                font-size: 20px;
            }
    }

    h4, h5 {
        margin: 0 !important;
        padding: 0 !important;
    }

    h5 {
        color: #868e96 !important;
        font-weight: 300;
        font-size: 14px;
    }


    h4 {
        color: #dbdcdc;
        margin-bottom: 6px !important;
        font-size: 16px;
    }

    .iconF {
        width: 43px;
        height: 40px;
        background-color: #d0bfff;
        border-radius: 50%;
        border: 2px solid #6741d9;
    }

    button {
        background: $orange;
        padding: 5px 20px;
        border: $orange;
        color: #dbdcdc;
        border-radius: 5px;

        &:hover {
            background: darken($orange, 10%);
            transition: all 0.2s;
            cursor: pointer;
        }
    }
    </style>
