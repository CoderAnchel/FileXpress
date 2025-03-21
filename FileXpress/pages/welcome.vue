<script setup>
import { useLoginStore } from '../stores/loginStore'
import { useWelcomeStore } from '../stores/welcomeStore'
import { useCreateStore } from '../stores/signUpStore'
import { animate} from "motion";
import { useToast } from "vue-toastification";
import { CreateAccount, Login } from "../lib/structures";
import { sendData } from '@/composables/useApi';


const sendMessage = async () => {
    const login = new Login("kouira@gmail.com","kgyspy10230");

    const response = await sendData("http://localhost:8082/app/login", login);

    console.log(response.data.value);
};

const toast = useToast();

const createStore = useCreateStore();
const loginStore = useLoginStore();
const globalState = useWelcomeStore();

async function onEnter(el, onComplete) {
    animate("li", { opacity: 0 })
    onComplete()
}

const phrases = [
    "Save all kind of Files...",
    "Share with Everyone...",
    "Organize your Workflow...",
    "Secure your Transfers...",
    "Live Chat?!"
]

// watch(() => loginStore.token, (newToken) => {
//     if (newToken) {
//         localStorage.setItem("token", newToken);
//         console.log('Token guardado en localStorage:', newToken)
//     }
// });
onMounted(() => {
    loginStore.loadToken();
});

useHead({
  title: 'FileXpress Welcome',
  meta: [
    {
      name: 'description',
      content: 'Descripción de la página de FileXpress'
    }
  ]
});
</script>
<template>
   <div class="main">
    <transition name="fade" mode="in-out">
        <div v-if="globalState.login" class="form">
            <h1 id="logo"><img src="public/logo-FileXpress.svg" alt=""> FileXpress</h1>
            <div class="content">
                <h1>Login <button @click="globalState.changeToCreate()">Create Account</button></h1>
                <!-- <div class="box-container">
                    <div class="box">
                        <img src="public/image_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                    </div>
                    <div class="box" style="background: #2970ff;">
                        <img src="public/movie_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                    </div>
                    <div class="box 3" style="background: #40cd64;">
                        <img src="public/description_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                    </div>

                </div> -->
                <div class="form-group">
                    <span>Email <img src="public/mail_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt=""></span>
                    <input type="email" placeholder="Email" v-model="loginStore.email">
                    <span>Password <img src="public/lock_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt=""></span>
                    <input type="password" placeholder="Password" v-model="loginStore.password" @keyup.enter="loginStore.loginFunc()"  >
                    <button @click="loginStore.loginFunc()">Enter</button>
                </div>
            </div>
            <div class="footer">
                <p>
                    Licensed under the <a href="https://opensource.org/licenses/MIT" target="_blank" rel="noopener noreferrer">MIT License</a>. You are free to use, modify, and distribute this code, provided the original license terms are respected. <a>Made By CoderAnchel</a>
                </p>
            </div>
        </div>
    </transition>
    <transition name="fade" mode="in-out">
        <div v-if="globalState.create" class="form">

            <div class="content">
                <h1>Create Account <button @click="globalState.changeToLogin()">Login</button></h1>
                <!-- <div class="box-container">
                    <div class="box">
                        <img src="public/image_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                    </div>
                    <div class="box" style="background: #2970ff;">
                        <img src="public/movie_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                    </div>
                    <div class="box 3" style="background: #40cd64;">
                        <img src="public/description_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt="">
                    </div>

                </div> -->
                <div class="form-group">
                    <span>Name <img src="public/badge_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt=""></span>
                    <input type="text" placeholder="Name" v-model="createStore.name">
                        <span>Username <img src="public/person_24dp_F3F3F3_FILL0_wght400_GRAD0_opsz24.svg" alt=""></span>
                        <input type="text" placeholder="Username" v-model="createStore.username">
                    <span>Email <img src="public/mail_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt=""></span>
                    <input type="email" placeholder="Email" v-model="createStore.email">
                    <span>Password <img src="public/lock_24dp_DBDCDC_FILL0_wght400_GRAD0_opsz24.svg" alt=""></span>
                    <input type="password" placeholder="Password"
                    @keydown.enter="createStore.signUp()"
                    v-model="createStore.password">
                    <button @click="createStore.signUp()">Submit</button>
                </div>
            </div>
            <div class="footer">
                <p>
                    Licensed under the <a href="https://opensource.org/licenses/MIT" target="_blank" rel="noopener noreferrer">MIT License</a>. You are free to use, modify, and distribute this code, provided the original license terms are respected. <a>Made By CoderAnchel</a>
                </p>
            </div>
        </div>
    </transition>
    <div class="show">
        <transition :css="false" @enter="onEnter">
            <div class="card-container">
                <h1 v-for="frase in phrases" :key="frase">{{ frase  }}</h1>
                <h1 id="logo"><img src="public/logo-FileXpress.svg" alt=""> </h1>
            </div>
        </transition>
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

    .page-enter-active,
    .page-leave-active {
    transition: all 0.4s;
    }
    .page-enter-from,
    .page-leave-to {
    opacity: 0;
    filter: blur(1rem);
    }

    /* Transición para el contenido entrante */
    .fade-enter-active {
    transition: opacity 0.7s ease-in;
    }
    .fade-enter-from {
    opacity: 0;
    }
    /* Contenido saliente desaparece sin transición */
    .fade-leave-active {
    transition: none;
    opacity: 0;
}

    .main {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100%;
    }

    .show {
        height: 100vh;
        background: $orange;
        width: 50%;

        .card-container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100%;
            width: 100%;
            flex-direction: column;

            h1 {
                color: $background-color;
                font-size: 2.4rem;
                font-weight: bold;
                font-family: "DM Serif Text", serif;
                font-weight: 400;
                font-style: italic;
            }

            .card-group {
                display: flex;
                justify-content: center;
                align-items: center;
                width: 100%;

                .card {
                    height: 70px;
                    width: 200px;
                    background: $card-bg;
                    margin: 20px;
                    border-radius: 5px;
                    display: flex;
                    align-items: center;
                    justify-content: space-between;
                    padding: 20px;

                    .img-container {
                        height: 100%;
                        width: 50%;
                        background: $red;
                        border-top-left-radius: 5px;
                        border-top-right-radius: 5px;
                        display: flex;
                        justify-content: center;
                        align-items: center;

                        img {
                            width: 50px;
                        }
                    }
                }
            }
        }
    }

    .form {
        height: 100vh;
        width: 50%;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;


        #logo {
                color: $basic-text-color;
                font-size: 2rem;
                margin: 20px 0;
                display: flex;
                align-items: center;
                margin-bottom: 40px;
                align-self: flex-start;
                margin-left: 10%;

                img {
                    margin-right: 10px;
                    width: 80px;
                }
            }

        .content {
            width: 75%;

            h1 {
                color: $basic-text-color;
                font-size: 2rem;
                margin: 30px 0;
                font-weight: bold;
                display: flex;
                justify-content: space-between;

                button {
                    background: $blue;
                    border: none;
                    border-radius: 20px;
                    padding: 10px 20px;
                    color: $basic-text-color;
                    font-size: 1rem;
                    cursor: pointer;
                    font-weight: bold;
                    margin-left: 20px;

                    &:hover {
                        background:  $yellow;
                        transition: all 0.3s;
                        color: $background-color;
                    }
                }
            }

            p {
                color: $light-gray;
                font-size: 1rem;
                margin: 10px 0;
                line-height: 1.5;
            }

            .box-container {
                display: flex;
                justify-self: center;

                .box {
                    background: $red;
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    width: 50px;
                    height: 50px;
                    border-radius: 10px;
                    margin-right: 10px;

                }
            }

            .form-group {
                display: flex;
                flex-direction: column;

                span {
                    display: flex;
                    align-items: center;
                    color: $basic-text-color;
                    font-size: 1rem;
                    margin: 10px 0;
                    font-weight: bold;

                    img {
                        margin-left: 10px;
                    }
                }

                input {
                    margin: 10px 0;
                    padding: 17px;
                    border: none;
                    border-radius: 5px;
                    background: $card-bg;
                    font-size: 1rem;
                    outline: none;
                    color: $basic-text-color;
                    border-radius: 30px;
                }

                button {
                    margin: 20px 0;
                    padding: 20px;
                    border: none;
                    border-radius: 5px;
                    background: $blue;
                    font-size: 1rem;
                    outline: none;
                    color: $basic-text-color;
                    border-radius: 30px;
                    cursor: pointer;
                    font-weight: bold;

                    &:hover {
                        background:  $yellow;
                        transition: all 0.3s;
                        color: $background-color;
                    }
                }
            }
        }

        .footer {
            width: 75%;
            color: $light-gray;
            font-size: 0.8rem;
            line-height: 1.5;

            a {
                color: $basic-text-color;
                text-decoration: none;
                font-weight: bold;
            }

            p {
                margin: 30px 0;
                text-align: center;
            }
        }
    }

</style>
