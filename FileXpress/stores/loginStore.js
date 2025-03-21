import { defineStore } from "pinia";
import { useToast } from "vue-toastification";

const toast = useToast();

export const useLoginStore = defineStore('loginStore', {
    state: () => ({
      email: "",
      password: "",
      token: null,
    }),
    actions: {
      async loginFunc() {
        console.log(localStorage.getItem("token"));
        try {
            const response = await fetch("http://localhost:8082/api/login", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    email: this.email,
                    password: this.password
                }),
            });

            if (response.ok) {
                const data = await response.text();
                const Bearer = "Bearer "+data; // Obtén el JWT como texto
                this.token = Bearer; // Guarda el token en localStorage
                console.log(this.token);  // Aquí debería aparecer el token

                // Guardar el token solo en el cliente
                if (process.client) {
                    localStorage.setItem('token', this.token);
                    localStorage.setItem('logged', true);

                    const router = useRouter();
                    router.push({ path: '/', replace: true });
                }

                // Limpiar los campos
                this.email = "";
                this.password = "";

                // Puedes guardar el token en localStorage o en algún estado global aquí
                toast.success("Login succesfull moving-on!!");
            } else {
                console.error("Failed to authenticate:", await response.text());
                toast.error("Failed to authenticate!");
            }
        } catch (error) {
            console.error("Error during fetch:", error);
            toast.error("Error during fetch!");
        }
      },
      loadToken() {
        if (process.client) {
          const tokenFromStorage = localStorage.getItem('token');
          this.token = tokenFromStorage ? tokenFromStorage : null;
        }
      }
    },
})
