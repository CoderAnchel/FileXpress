import { defineStore } from "pinia";
import { useToast } from "vue-toastification";

const toast = useToast();

export const useDashboardStore = defineStore('dashboardStore', {
    state: () => ({
        windows: {
            Overview: {
                active: true,
            },
            Profile: {
                active: false,
            },
            Settings: {
                ownWindows: {
                    Account: {
                        active: true,
                    },
                    Privacy: {
                        active: false,
                    },
                    Apparence: {
                        active: false,
                    },
                    Notifications: {
                        active: false,
                    },
                    Security: {
                        active: false,
                    },
                },
                active: false,
                selectedWindow: 'Account',
                name: null,
                email: null,
                bio: "",
                phone: "",
                username: ""
            },
            Friends: {
                active: false,
                add: false,
                userTo: null,
                windows: {
                    request: false,
                }
            },
            Trash: {
                active: false,
            },
            Favorites: {
                notis: 0,
                active: false,
            },
            MyFiles: {
                active: false,
            },
            RecentFiles: {
                notis: 0,
                active: false,
            },
            SharedFiles: {
                active: false,
            },
            SharedFolder: {
                active: false,
            },
            Teams: {
                active: false,
            },
            Plans: {
                active: false,
            },
            Search: {
                active: false,
            },
            World: {
                active: false,
            }
        },
        user: {
            basic: {
                id: null,
                name: null,
                email: null,
                bio: "",
                phone: "",
                username: "",
            },
            friends: null,
            requests: null,
        },
        searchData: {
            value: null,
            data: null,
            loading: null,
        },
        messagues: {
            windows: {
                Chat: false,
                Start: false,
                Main: true,
            },
            addChats: [],
            chats: [],
            selectedChat: null,
            messagues: [],
            messague: null,
        },
        selectedWindow: 'Overview',
        demoMode: false,
        shocket: null,
        registered: null,
    }),
    actions: {
        toggleWindow(windowName) {

            for (const key in this.windows) {
                if (this.windows.hasOwnProperty(key)) {
                    this.windows[key].active = false;
                }
            }
            this.windows[windowName].active = true;
            this.selectedWindow = windowName;
            this.searchData.data = null;
            this.searchData.loading = null;
        },
        toggleInternSettingsWindow(windowName) {
            for (const key in this.windows.Settings.ownWindows) {
                if (this.windows.Settings.ownWindows.hasOwnProperty(key)) {
                    this.windows.Settings.ownWindows[key].active = false;
                }
            }
            this.windows.Settings.ownWindows[windowName].active = true;
            this.windows.Settings.selectedWindow = windowName;
        },
        toggleInternMessaguesWindow(windowName, chat) {
            if (this.messagues.selectedChat !== null) {
                this.disconnectFromChat();
            }
            for (const key in this.messagues.windows) {
                if (this.messagues.windows.hasOwnProperty(key)) {
                    this.messagues.windows[key] = false;
                }
            }
            this.messagues.windows[windowName] = true;
            this.windows.Settings.selectedWindow = windowName;

            if (chat) {
                if (this.messagues.selectedChat !== null) {
                    this.disconnectFromChat();
                }
                this.messagues.selectedChat = chat;
                this.loadChats(chat.chatID);
                this.registerInChat()
            } else {
                this.messagues.selectedChat = null;
                this.messagues.messagues = [];
            }
        },
        async initializeConnection() {
            if(!this.shocket || this.shocket.readyState !== WebSocket.OPEN) {
                const socketUrl = `ws://localhost:8082/ws/chat`;
                this.shocket = new WebSocket(socketUrl);

                this.shocket.onopen = () => {
                    console.log("Conexion established!!");
                }

                this.shocket.onmessage = (event) => {
                    console.log('Message from server:', event.data);
                    // Aquí puedes manejar los mensajes entrantes
                    if(this.messagues.selectedChat !== null) {
                        const data = JSON.parse(event.data);
                        if (data.userID === this.user.basic.id) {
                            data.isMe = "true";
                        } else {
                            data.isMe = "false";
                        }
                        this.messagues.messagues.push(data);
                    }
                };

                this.shocket.onerror = (error) => {
                    console.error('WebSocket error:', error);
                  };

                this.shocket.onclose = () => {
                    console.log('WebSocket connection closed');
                };
            }
        },
        async closeConnection() {
            if (this.socket) {
              this.socket.close();
              this.socket = null;
            }
        },
        registerInChat() {
            console.log("Trying to register...");
            const payload = {
                type: 'register',
                chatId: this.messagues.selectedChat.chatID,
                userId: this.user.basic.id,
            };

            // Verificar si el WebSocket está inicializado
            if (this.shocket) {
                console.log('WebSocket initialized:', this.socket);

                // Verificar el estado del WebSocket
                if (this.shocket.readyState === WebSocket.OPEN) {
                    try {
                        // Intentamos enviar el mensaje
                        this.shocket.send(JSON.stringify(payload));
                        console.log(`Registered user ${this.user.basic.id} in chat ${this.messagues.selectedChat.chatID}`);
                    } catch (error) {
                        console.error('Failed to send registration payload:', error);
                    }
                } else {
                    console.error('WebSocket is not open. Cannot register user. Current state:', this.socket.readyState);
                }
            } else {
                console.error('WebSocket is not initialized.');
            }
        },
        disconnectFromChat() {
            if (this.shocket && this.shocket.readyState === WebSocket.OPEN) {
                const payload = {
                    type: 'disconnect',
                    chatId: this.messagues.selectedChat.chatID,
                    userId: this.user.basic.id,
                };
                  this.shocket.send(JSON.stringify(payload));
                  this.messagues.messague = "";
                } else {
                  console.error('WebSocket is not open. Cannot send message.');
                }
        },
        shocketMessague() {
            if (this.shocket && this.shocket.readyState === WebSocket.OPEN) {
            const payload = {
                type: 'message',
                chatId: this.messagues.selectedChat.chatID,
                userId: this.user.basic.id,
                message: this.messagues.messague
            };
              this.shocket.send(JSON.stringify(payload));
              this.messagues.messague = "";
            } else {
              console.error('WebSocket is not open. Cannot send message.');
            }
        },
        async loadBasicUser() {
            try {
                const response = await fetch("http://localhost:8082/app/getUserBasicData", {
                    method: "GET",
                    headers: {
                        "Content-Type": "application/json",
                        "Authorization": localStorage.getItem("token"),
                    },
                });

                if (response.ok) {
                    const data = await response.json();

                    this.user.basic.id = data.id;
                    this.user.basic.name = data.name;
                    this.user.basic.email = data.email;
                    this.user.basic.bio = data.bio;
                    this.user.basic.phone = data.phone;
                    this.user.basic.username = data.username;
                } else {
                    console.error("Failed to authenticate:", await response.text());
                    if (process.client) {
                        localStorage.removeItem('token');
                        localStorage.removeItem('logged');
                        const router = useRouter();
                        router.push({ path: '/welcome', replace: true });
                    }
                }
            } catch (error) {
                console.error("Error during fetch:", error);
                if (process.client) {
                    localStorage.removeItem('token');
                    localStorage.removeItem('logged');
                    const router = useRouter();
                    router.push({ path: '/welcome', replace: true });
                }
            }
        },
        async userFriends() {
            try {
                const response = await fetch("http://localhost:8082/app/Friends", {
                    method: "GET",
                    headers: {
                        "Content-Type": "application/json",
                        "Authorization": localStorage.getItem("token"),
                    },
                });

                if (response.ok) {
                    const data = await response.json();

                    this.user.friends = data;
                } else {
                    console.error("Failed to authenticate:", await response.text());
                }
            } catch (error) {
                console.error("Error during fetch:", error);
            }
        },
        async sendRequest(){
            const request = {
                from_id: this.user.basic.id,
                to_id: this.windows.Friends.userTo,
            }

            try {
                const response = await fetch("http://localhost:8082/app/sendFriendRequest", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                        "Authorization": localStorage.getItem("token"),
                    },
                    body: JSON.stringify(request),
                });

                console.log(response);

                if (response.ok) {
                    const data = await response.text();

                    this.windows.Friends.userTo = null;
                    console.log(data);
                    toast.success("Request Send!!");
                } else {
                    console.error("Failed to authenticate:", await response.text());

                    toast.error("Error sending request!");
                }
            } catch (error) {
                console.error("Error during fetch:", error);

                toast.error("Error sending request 21!");
            }
        },
        async sendRequestFromSearch(id) {
            const request = {
                from_id: this.user.basic.id,
                to_id: id,
            }

            try {
                const response = await fetch("http://localhost:8082/app/sendFriendRequest", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                        "Authorization": localStorage.getItem("token"),
                    },
                    body: JSON.stringify(request),
                });

                console.log(response);

                if (response.ok) {
                    const data = await response.text();

                    this.windows.Friends.userTo = null;
                    toast.success("Request Send!!");
                } else {
                    console.error("Failed to authenticate:", await response.text());

                    toast.error("Request all ready sended!");
                }
            } catch (error) {
                console.error("Error during fetch:", error);

                toast.error("Error sending request 21!");
            }
        } ,
        async userRequests() {
            try {
                const response = await fetch(`http://localhost:8082/app/checkRequests`, {
                    method: "GET",
                    headers: {
                        "Content-Type": "application/json",
                        "Authorization": localStorage.getItem("token"),
                    },
                });

                if (response.ok) {
                    const data = await response.json();

                    this.user.requests = data;
                } else {
                    console.error("No requests: ", await response.text());
                    this.user.requests = []
                }
            } catch (error) {
                console.error("Error during fetch:", error);
                this.user.requests = []
            }
        },
        async userFriends() {
            try {
                const response = await fetch("http://localhost:8082/app/Friends", {
                    method: "GET",
                    headers: {
                        "Content-Type": "application/json",
                        "Authorization": localStorage.getItem("token"),
                    },
                });

                if (response.ok) {
                    const data = await response.json();

                    this.user.friends = data;
                } else {
                    console.error("Failed to authenticate:", await response.text());
                }
            } catch (error) {
                console.error("Error during fetch:", error);
            }
        },
        async acceptFriend(id){
            try {
                const response = await fetch(`http://localhost:8082/app/acceptRequest?id=${id}`, {
                    method: "GET",
                    headers: {
                        "Content-Type": "application/json",
                        "Authorization": localStorage.getItem("token"),
                    },
                });

                if (response.ok) {
                    this.userFriends();
                    this.userRequests();
                    this.getChats();

                    toast.success("Request Accepted!!");
                } else {
                    console.error("Failed to authenticate:", await response.text());
                    toast.error("Error accepting request!");
                }
            } catch (error) {
                console.error("Error during fetch:", error);
            }
        },
        async searchUser(){
            this.searchData.data = false;
            this.searchData.loading = true;
            for (const key in this.windows) {
                if (this.windows.hasOwnProperty(key)) {
                    this.windows[key].active = false;
                }
            }
            this.windows["Search"].active = true;
            this.selectedWindow = "Search";

            try {
                const response = await fetch(`http://localhost:8082/app/search?value=${this.searchData.value}`, {
                    method: "GET",
                    headers: {
                        "Content-Type": "application/json",
                        "Authorization": localStorage.getItem("token"),
                    },
                });

                if (response.ok) {
                    const data = await response.json();
                    this.searchData.data = data;
                    data.forEach(element => {
                        if (element.id === this.user.basic.id) {
                            element.isMe = true;
                        }

                        if (this.user.friends) {
                            this.user.friends.forEach(friend => {
                                if (element.id === friend.id) {
                                    element.isFriend = true;
                                }
                            });
                        }
                    });

                    this.searchData.loading = false;
                } else {
                    console.error("Failed to authenticate:", await response.text());
                }
            } catch (error) {
                console.error("Error during fetch:", error);
            }
        },
        async modify(type) {
            console.log(this.windows.Settings.name);
            try {
                const response = await fetch(`http://localhost:8082/app/user/modified`, {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                        "Authorization": localStorage.getItem("token"),
                    },
                    body: JSON.stringify({
                        "type": type,
                        "value": this.windows.Settings[type],
                    }),
                });

                console.log(response);

                if (response.ok) {
                    const data = await response.text();
                    console.log(data);
                    toast.success("Name modified!!");
                    this.windows.Settings[type] = null;
                    this.loadBasicUser();
                } else {
                    toast.error("Error modifying name!");
                }
            } catch (error) {
                console.error("Error during fetch:", error);
            }
        },
        async createChat(to_id) {
            try {
                const response = await fetch(`http://localhost:8082/app/chat/new`, {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                        "Authorization": localStorage.getItem("token"),
                    },
                    body: JSON.stringify({
                        "from_id": this.user.basic.id,
                        "to_id": to_id
                    }),
                });

                console.log(response);

                if (response.ok) {
                    const data = await response.text();
                    console.log(data);
                    toast.success("Chat started!!");
                    this.getChats();
                } else {
                    toast.error("Chat all ready exist!");
                }
            } catch (error) {
                console.error("Error during fetch:", error);
            }
        },
        async getChats() {
            try {
                const response = await fetch(`http://localhost:8082/app/chat/get`, {
                    method: "GET",
                    headers: {
                        "Content-Type": "application/json",
                        "Authorization": localStorage.getItem("token"),
                    }
                });

                console.log(response);

                if (response.ok) {
                    const data = await response.json();

                    this.messagues.chats = data;

                    this.messagues.addChats = [];
                    console.log(this.user.friends);
                    if (this.user.friends) {
                        this.user.friends.forEach(friend => {
                            const chatExists = this.messagues.chats.some(chat => chat.userID === friend.id);
                            if (!chatExists) {
                                this.messagues.addChats.push(friend);
                            }
                        });
                    }

                } else {
                    toast.error("Chat all ready exist!");
                }
            } catch (error) {
                console.error("Error during fetch:", error);
            }
        },
        async loadChats(id) {
            try {
                const response = await fetch(`http://localhost:8082/app/chat/getMessagues?chatID=${id}`, {
                    method: "GET",
                    headers: {
                        "Content-Type": "application/json",
                        "Authorization": localStorage.getItem("token"),
                    }
                });

                console.log(response);

                if (response.ok) {
                    const data = await response.json();
                    console.log(data);
                    this.messagues.messagues = data;

                    this.messagues.messagues.forEach(messague => {
                        if (messague.userID === this.user.basic.id) {
                            messague.isMe = "true";
                        } else {
                            messague.isMe = "false";
                        }
                    })
                } else {

                }
            } catch (error) {
                console.error("Error during fetch:", error);
            }
        },
        //just for testing
        async sendMessague() {
            try {
                const response = await fetch(`http://localhost:8082/app/chat/send`, {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                        "Authorization": localStorage.getItem("token"),
                    },
                    body: JSON.stringify({
                        "chatID": this.messagues.selectedChat.chatID,
                        "messague": this.messagues.messague,
                    }),
                });

                console.log(response);

                if (response.ok) {
                    this.loadChats(this.messagues.selectedChat.chatID);
                    this.messagues.messague = null;
                } else {

                }
            } catch (error) {
                console.error("Error during fetch:", error);
            }
        },
        logOut() {
            if (process.client) {
                localStorage.removeItem('token');
                localStorage.removeItem('logged');
                const router = useRouter();
                router.push({ path: '/welcome', replace: true });
            }
        }
    },
});
