import { defineStore } from "pinia";

export const useWelcomeStore = defineStore('welcomeStore', {
    state: () => ({
        create: false,
        login: true
    }),
    actions: {
        changeToCreate() {
            this.create = true
            this.login = false
        },
        changeToLogin() {
            this.create = false
            this.login = true
        }
    }
})
