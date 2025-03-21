import Toast, { POSITION } from "vue-toastification";
import "vue-toastification/dist/index.css";

export default defineNuxtPlugin((nuxtApp) => {
  nuxtApp.vueApp.use(Toast, {
    position: POSITION.BOTTOM_RIGHT, // Ajusta la posición según tus necesidades
    timeout: 3000,                    // Duración del mensaje
    draggable: true,                  // Permitir arrastrar el toast
    closeOnClick: true                // Cerrar al hacer clic
  });
});
