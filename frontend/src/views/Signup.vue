<template>
  <div class="container">
    <!--    Logo Div-->
    <div class="row">
      <div class="col-12 text-center pt-3">
        <router-link :to="{ name: 'Home' }">
          <img id="logo" src="../assets/logo.png" />
        </router-link>
      </div>
    </div>

    <div class="row">
      <div class="col-12 justify-content-center d-flex flex-row pt-3">
        <div
          id="signup-div"
          class="flex-item border"
          style="font-family: sans-serif"
        >
          <h2 class="pt-4 pl-4 text-center" style="font-family: sans-serif">
            Create Account
          </h2>
          <form @submit="signup" class="pt-4 pl-4 pr-4">
            <div class="form-group">
              <label>Name</label>
              <input
                type="name"
                class="form-control"
                v-model="name"
                placeholder="your name"
                required
              />
            </div>

            <div class="form-group">
              <label>Email</label>
              <input
                type="email"
                class="form-control"
                v-model="email"
                placeholder="example@gmail.com"
                required
              />
            </div>

            <div class="form-group">
              <label>Password</label>
              <input
                type="password"
                class="form-control"
                v-model="password"
                placeholder="********"
                required
              />
            </div>
            <div class="text-center">
              <button
                type="submit"
                class="btn btn-primary mt-2 py-0"
                style="font-family: sans-serif"
              >
                Create Account
              </button>
            </div>
          </form>
          <hr />
          <small class="form-text text-muted pt-2 pl-4 text-center"
            >Already Have an Account?</small
          >
          <p class="text-center">
            <router-link
              class="btn btn-dark text-center mx-auto px-5 py-1 mb-2"
              :to="{ name: 'Signin' }"
              >Signin Here</router-link
            >
          </p>
        </div>
      </div>
    </div>
  </div>
</template>
    
    <script>
export default {
  name: "Signup",
  props: ["baseURL"],
  data() {
    return {
      email: null,
      name: null,
      password: null,
      passwordConfirm: null,
    };
  },
  methods: {
    async signup(e) {
      e.preventDefault();
      // if the password matches
      //   if (this.password === this.passwordConfirm) {
      // make the post body
      const user = {
        email: this.email,
        name: this.name,
        password: this.password,
      };

      // call the API
      await axios
        .post(`${this.baseURL}user/signup`, user)
        .then(() => {
          // redirect to home page
          this.$router.replace("/");
          swal({
            text: "User signup successful. Please Login",
            icon: "success",
            closeOnClickOutside: false,
          });
        })
        .catch((err) => {
          console.log(err);
        });
      //   } else {
      //     // passwords are not matching
      //     swal({
      //       text: "Error! Passwords are not matching",
      //       icon: "error",
      //       closeOnClickOutside: false,
      //     });
      //   }
    },
  },
};
</script>
    
    <style scoped>
.btn-dark {
  background-color: #e7e9ec;
  color: #000;
  font-size: smaller;
  border-radius: 0;
  border-color: #adb1b8 #a2a6ac #a2a6ac;
}

.btn-primary {
  background-color: orange;
  color: black;
  border-color: #a88734 #9c7e31 #846a29;
  border-radius: 0;
}

#logo {
  width: 150px;
}

@media only screen and (min-width: 992px) {
  #signup-div {
    width: 40%;
  }
}
</style>
    