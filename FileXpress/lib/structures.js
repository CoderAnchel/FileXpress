class Login {
    constructor(email, password) {
      this.email = email;
      this.password = password;
    }
}

class CreateAccount {
    constructor(name, email, password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}

export { CreateAccount, Login };
