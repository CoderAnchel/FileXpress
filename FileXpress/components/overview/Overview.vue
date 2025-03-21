<script setup>
import TypeCard from "./TypeCard.vue";
import FileCard from "./FileCard.vue";
import FileRow from "~/components/overview/FileRow.vue";
const dashState = useDashboardStore();

</script>
<template>
  <div class="overview">
    <div class="row1">
      <h2>Overview Storage</h2>
      <div class="cardWrapp">
        <TypeCard
          title="Image"
          icon-src="image_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24 (1).svg"
          color="#ff4646"
        />

        <TypeCard
          title="Video"
          icon-src="video_library_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg"
          color="#2970ff"
        />

        <TypeCard
          title="Document"
          icon-src="draft_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg"
          color="#40cd64"
        />

        <TypeCard
          title="Others"
          icon-src="inventory_2_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg"
          color="#f3cc30"
        />
      </div>
    </div>
    <div class="row1">
      <h2>Suggested</h2>
      <div class="cardWrapp">
        <FileCard title="Trabajo_2024" file-type="docx"/>
        <FileCard title="Gladis" file-type="pdf"/>
        <FileCard title="Alfagor" file-type="fx"/>
        <FileCard title="Mauro" file-type="xlsx"/>
      </div>
    </div>
    <div class="row1">
      <h2>Recent Files</h2>
      <div class="table-container">
        <table class="file-table">
          <thead>
          <tr>
            <th>
              <input class="check" type="checkbox" name="" id="">
              Name
            </th>
            <th style="display: flex; align-items: center; gap: 10px;">
              Size
              <img style="width:17px ; " src="public/swap_vert_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
            </th>
            <th>
               <div style="display: flex; align-items: center; gap: 5px">
                  <img style="width:17px ; " src="public/share_24dp_D9D9D9_FILL0_wght400_GRAD0_opsz24.svg" alt="">Shared
              </div>
            </th>
            <th style="display: flex; align-items: center; gap: 10px;">
              Last Modified
              <img style="width:17px ; " src="public/swap_vert_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
            </th>
            <th>Options</th>
          </tr>
          </thead>
          <tbody>
          <FileRow file-name="Documento1" file-type="docx" size="243" volume-type="KB" shared="Me" date="2023-09-25"/>
          <FileRow file-name="Documento1" file-type="docx" size="243" volume-type="KB" shared="Me" date="2023-09-25"/>
          <FileRow file-name="Documento1" file-type="docx" size="243" volume-type="KB" shared="Me" date="2023-09-25"/>
          <FileRow file-name="Documento1" file-type="docx" size="243" volume-type="KB" shared="Me" date="2023-09-25"/>
          <FileRow file-name="Documento1" file-type="docx" size="243" volume-type="KB" shared="Me" date="2023-09-25"/>
          <FileRow file-name="Documento1" file-type="docx" size="243" volume-type="KB" shared="Me" date="2023-09-25"/>
          <FileRow file-name="Documento1" file-type="docx" size="243" volume-type="KB" shared="Me" date="2023-09-25"/>
          <FileRow file-name="Documento1" file-type="docx" size="243" volume-type="KB" shared="Me" date="2023-09-25"/>
          </tbody>
        </table>
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
</style>
