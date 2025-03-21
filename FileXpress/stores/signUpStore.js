import { defineStore } from "pinia";
import { useToast } from "vue-toastification";

const toast = useToast();

export const useCreateStore = defineStore('createStore', {
    state: () => ({
      name: "",
      email: "",
      password: "",
      username: "",
    }),
    actions: {
        async signUp() {
            if (this.name === "" || this.email === "" || this.password === "" || this.username === "") {
                toast.error("Please fill all the fields!");
                return;
            }

            try {

                const response = await fetch("http://localhost:8082/api/addUser", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                    },
                    body: JSON.stringify({
                        name: this.name,
                        email: this.email,
                        password: this.password,
                        username: this.username
                    }),
                });

                if (response.ok) {
                    const data = await response.json();
                    console.log(data);

                    this.name = "";
                    this.email = "";
                    this.password = "";
                    this.username = "";

                    toast.success("User created successfully!");
                } else {
                    toast.error("User or Email All Ready exist!!");
                }
            } catch (error) {
                console.error(error);
                toast.error("Error during fetch!");
            }
        }
    }
  })
