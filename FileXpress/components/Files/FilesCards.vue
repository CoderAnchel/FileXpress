<script setup>
import FileCard from "../overview/FileCard.vue";
const dashState = useDashboardStore();

</script>
<template>
    <div class="filesCards">
        <h3>Folders</h3>
        <div class="folders">
            <div class="folder">
                <div class="left">
                    <img src="public/folder_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                    <span>My Files</span>
                </div>

                <img class="dots" src="public/more_horiz_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24 (1).svg" alt="">
            </div>
            <div class="folder">
                <div class="left">
                    <img src="public/folder_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                    <span>My Files</span>
                </div>

                <img class="dots" src="public/more_horiz_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24 (1).svg" alt="">
            </div>
            <div class="folder">
                <div class="left">
                    <img src="public/folder_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                    <span>My Files</span>
                </div>

                <img class="dots" src="public/more_horiz_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24 (1).svg" alt="">
            </div>
            <div class="folder">
                <div class="left">
                    <img src="public/folder_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                    <span>My Files</span>
                </div>

                <img class="dots" src="public/more_horiz_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24 (1).svg" alt="">
            </div>
            <div class="folder">
                <div class="left">
                    <img src="public/folder_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                    <span>My Files</span>
                </div>

                <img class="dots" src="public/more_horiz_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24 (1).svg" alt="">
            </div>
            <div class="folder">
                <div class="left">
                    <img src="public/folder_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                    <span>My Files</span>
                </div>

                <img class="dots" src="public/more_horiz_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24 (1).svg" alt="">
            </div>
            <div class="folder">
                <div class="left">
                    <img src="public/folder_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                    <span>My Files</span>
                </div>

                <img class="dots" src="public/more_horiz_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24 (1).svg" alt="">
            </div>
            <div class="folder">
                <div class="left">
                    <img src="public/folder_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                    <span>My Files</span>
                </div>

                <img class="dots" src="public/more_horiz_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24 (1).svg" alt="">
            </div>
        </div>
        <h3>Recent Files</h3>
        <div class="cardWrapp">
        <FileCard title="Trabajo_2024" file-type="docx"/>
        <FileCard title="Gladis" file-type="pdf"/>
        <FileCard title="Alfagor" file-type="fx"/>
        <FileCard title="Mauro" file-type="xlsx"/>
        <FileCard title="Trabajo_2024" file-type="docx"/>
        <FileCard title="Gladis" file-type="pdf"/>
        <FileCard title="Alfagor" file-type="fx"/>
        <FileCard title="Mauro" file-type="xlsx"/>
        <FileCard title="Trabajo_2024" file-type="docx"/>
        <FileCard title="Gladis" file-type="pdf"/>
        <FileCard title="Alfagor" file-type="fx"/>
        <FileCard title="Mauro" file-type="xlsx"/>
        <FileCard title="Trabajo_2024" file-type="docx"/>
        <FileCard title="Gladis" file-type="pdf"/>
        <FileCard title="Alfagor" file-type="fx"/>
        <FileCard title="Mauro" file-type="xlsx"/>
        <FileCard title="Trabajo_2024" file-type="docx"/>
        <FileCard title="Gladis" file-type="pdf"/>
        <FileCard title="Alfagor" file-type="fx"/>
        <FileCard title="Mauro" file-type="xlsx"/>
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

   .cardWrapp {
  display: flex;
  justify-content: space-between;
  gap: 20px;
  flex-wrap: wrap;
  padding: 0 60px;
}

.folders {
  display: flex;
  gap: 20px;
  flex-wrap: wrap;
  padding: 0 60px;

  .folder {
    width: 18%;
    height: 50px;
    background: $card-bg;
    border-radius: 5px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 0 20px;

    &:hover {
        cursor: pointer;
        background: #1f1f1f;
        transition: all 0.2s;
    }

    .left {
        display: flex;
        gap: 5px;
        align-items: center;
    }

    img {
        width: 20px;
        height: 20px;

        &:hover {
            rotate: 360deg;
            transition: all 0.5s;
        }
    }
  }
}

 .filesCards {
    overflow-y: auto;
    height: 65%;
 }

 h3 {
    padding: 10px 60px;
 }


 .filesCards::-webkit-scrollbar {
  width: 8px; /* Ancho de la barra de desplazamiento */
}

/* Personaliza el track (fondo de la barra de desplazamiento) */
.filesCards::-webkit-scrollbar-track {
  background: lighten($color: $background-color, $amount: 3); /* Color del fondo del track */
  border-radius: 5px; /* Esquinas redondeadas opcionales */
  scroll-behavior: smooth;
}

/* Personaliza el thumb (la parte que se desplaza) */
.filesCards::-webkit-scrollbar-thumb {
  background-color: #555; /* Color del thumb */
  border-radius: 5px; /* Redondeo del thumb */
  border: 2px solid $card-bg; /* Opcional: agrega un borde para mejor contraste */
}

/* Cambia el color del thumb al pasar el cursor */
.filesCards::-webkit-scrollbar-thumb:hover {
  background-color: $orange; /* Un color más claro al hacer hover */
}
</style>
