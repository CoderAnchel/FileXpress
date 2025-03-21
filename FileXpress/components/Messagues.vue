<script setup>
import { ref, onMounted, watch } from 'vue';
import { useDashboardStore } from "../stores/dashboardStore";
import MessaguesHeader from "./chat/MessaguesHeader.vue";
import StartHeader from "./chat/StartHeader.vue";
import ChatHeader from "./chat/ChatHeader.vue";
//TESTING
import data from "../testing/testingDATA/data.js";
import FriendAdd from "./chat/FriendAdd.vue";
import Messague from "./chat/Messague.vue";

const dashState = useDashboardStore();
const messagesContainer = ref(null);

const scrollToBottom = () => {
  const container = messagesContainer.value;
  if (container) {
    container.scrollTop = container.scrollHeight;
  }
};

// Desplaza el scroll al final cuando el componente se monta
onMounted(() => {
  nextTick(() => {
    scrollToBottom();
  });
});

// Observa los cambios en los mensajes del store y asegura el scroll
watch(
  () => dashState.messagues.messagues.length, // Solo observa cambios en la longitud del array
  () => {
    nextTick(() => scrollToBottom()); // nextTick asegura que los cambios en el DOM estén listos
  }
);

const handleSend = () => {
  dashState.shocketMessague()
}
</script>
<template>
  <div class="messages">
    <StartHeader v-if="dashState.messagues.windows.Start" key="header" />
    <MessaguesHeader v-if="dashState.messagues.windows.Main" key="header" />
    <ChatHeader v-if="dashState.messagues.windows.Chat" key="header" />

    <!-- Main chats viewer -->
    <div v-if="dashState.messagues.windows.Main" class="chats">
      <ChatPrev
        @click="dashState.toggleInternMessaguesWindow('Chat', chat)"
        v-for="chat in dashState.messagues.chats"
        :key="chat"
        :name="chat.name"
        :msg="chat.lastMessague"
      />
    </div>

    <!-- Start conver -->
    <div v-if="dashState.messagues.windows.Start" class="chats">
      <FriendAdd
        class="friendADD"
        v-for="friend in dashState.messagues.addChats"
        :key="friend"
        :name="friend.name"
        :user="friend.username"
        :id="friend.id"
      />
    </div>

    <div class="chat-page" v-if="dashState.messagues.windows.Chat">
      <div class="content" ref="messagesContainer">
        <Messague v-for="message in dashState.messagues.messagues" :key="message" :message="message.messague" :time="message.time" :from="message.isMe" />
      </div>
      <div class="multi-input">
        <div class="input">
          <img src="public/image_24dp_E86114_FILL0_wght400_GRAD0_opsz24.svg" alt="">
          <img src="public/gif_box_24dp_E86114_FILL0_wght400_GRAD0_opsz24.svg" alt="">
          <img src="public/add_reaction_24dp_E86114_FILL0_wght400_GRAD0_opsz24.svg" alt="">
          <input type="text" placeholder="Type a message" v-model="dashState.messagues.messague" @keydown.enter="handleSend()" />
          <img src="public/send_24dp_E86114_FILL0_wght400_GRAD0_opsz24.svg" alt="">
        </div>
      </div>
    </div>
  </div>
</template>
<style lang="scss" scoped>
@import "@/assets/dashboard.scss";
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

.friendADD:hover {
  background: $card-bg !important;
  transition: all 0.4s;
  cursor: pointer;
}

.content {
  width: 100% !important;
  height: 400px;
  max-height: 270px;
  overflow-y: auto;
  border-bottom: 2px solid $card-bg !important;
}

.multi-input {
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 100%;
  height: 63px;
}

.input {
  background: $card-bg;
  width: 100%;
  height: 80%;
  margin: 10px 8px;
  border-radius: 10px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 10px;

  img {
    width: 20px;
    height: 20px;

    &:hover {
      cursor: pointer;
    }
  }

  input {
    width: 100%;
    height: 100%;
    background: $card-bg;
    border: none;
    color: $basic-text-color;
    font-size: 15px;
    padding: 0 10px;
    outline: none; /* This will remove the blue border */
    color: $basic-text-color;
  }
}


   /* Apunta solo a navegadores basados en WebKit como Chrome, Safari */
.content::-webkit-scrollbar {
  width: 8px; /* Ancho de la barra de desplazamiento */
}

/* Personaliza el track (fondo de la barra de desplazamiento) */
.content::-webkit-scrollbar-track {
   background: none; /* Color del fondo del track */
  border-radius: 5px; /* Esquinas redondeadas opcionales */
  scroll-behavior: smooth;
}

/* Personaliza el thumb (la parte que se desplaza) */
.content::-webkit-scrollbar-thumb {
  background-color: #555; /* Color del thumb */
  border-radius: 5px; /* Redondeo del thumb */
  border: 2px solid $card-bg; /* Opcional: agrega un borde para mejor contraste */
}

/* Cambia el color del thumb al pasar el cursor */
.sidebar::-webkit-scrollbar-thumb:hover {
  background-color: $orange; /* Un color más claro al hacer hover */
}
</style>
