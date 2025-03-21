<script setup>
import TypeCard from "./TypeCard.vue";
defineProps({
    fileType: String,
    fileName: String,
    size: Number,
    volumeType: String,
    shared: String,
    date: String
});

const dashState = useDashboardStore();
</script>
<template>
    <tr>
        <td style="display: flex; align-items: center; gap: 10px;">
            <input class="check" type="checkbox" name="" id="">
            <img
                src="public/docs_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg"
                alt=""
            />
            {{ fileName }}.{{ fileType }}
        </td>
        <td>{{ size }} {{ volumeType }}</td>
        <td style="display: flex; gap: 5px; align-items: center" v-if="shared === 'Me'"><img style="width:20px ; " src="public/person_24dp_D9D9D9_FILL0_wght400_GRAD0_opsz24.svg" alt="">{{ shared }}</td>
        <td style="display: flex; gap: 5px; align-items: center" v-if="shared === 'Group'">{{ shared }}</td>
        <td>
            <div style="display: flex; align-items: center; gap: 5px">
                <img style="width:20px ; " src="public/schedule_24dp_D9D9D9_FILL0_wght400_GRAD0_opsz24.svg" alt="">{{ date }}
            </div>
        </td>
        <td>options</td>
    </tr>
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

    .table-container {
        overflow-x: auto; /* Aplica el desplazamiento horizontal aquí */
    }

    .file-table {
        width: 100%;
        border-collapse: collapse;
        color: $light-gray;

        th,
        td {
            padding: 10px;
            text-align: left;
        }

        td {
            font-weight: 400 !important;
        }

        th {
            border-bottom: 1px solid $card-bg;
            font-weight: 500;
        }

        tbody {
            font-size: 14px;

            tr {
                margin-bottom: 30px;
            }

            tr:hover {
                background: #1f1f1f;
                transition: all 0.3s;
                color: $orange;
            }
        }
    }
}

.overview {
    padding: 0;
    margin: 0;
    padding: 0 60px;
    height: 73%;
    overflow-y: auto;
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

.overview::-webkit-scrollbar {
    width: 8px; /* Ancho de la barra de desplazamiento */
}

/* Personaliza el track (fondo de la barra de desplazamiento) */
.overview::-webkit-scrollbar-track {
    background: lighten($color: $background-color, $amount: 3); /* Color del fondo del track */
    border-radius: 5px; /* Esquinas redondeadas opcionales */
    scroll-behavior: smooth;
}

/* Personaliza el thumb (la parte que se desplaza) */
.overview::-webkit-scrollbar-thumb {
    background-color: #555; /* Color del thumb */
    border-radius: 5px; /* Redondeo del thumb */
    border: 2px solid $card-bg; /* Opcional: agrega un borde para mejor contraste */
}

/* Cambia el color del thumb al pasar el cursor */
.overview::-webkit-scrollbar-thumb:hover {
    background-color: $orange; /* Un color más claro al hacer hover */
}

img {
    width: 17px;
}
</style>
