<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <!--    Logo-->
    <router-link class="navbar-brand" to="/">
      <img id="logo" src="../assets/logo.png" alt="image" />
    </router-link>

    <!--    Burger Button-->
    <button
      class="navbar-toggler"
      type="button"
      data-toggle="collapse"
      data-target="#navbarSupportedContent"
      aria-controls="navbarSupportedContent"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse ptop" id="navbarSupportedContent">
      <!--      Search Bar-->
      <form class="form-inline ml-auto mr-auto dnone">
        <div class="input-group">
          <input
            size="45"
            type="text"
            class="form-control"
            placeholder="Search Items"
            aria-label="Username"
            aria-describedby="basic-addon1"
          />
          <div class="input-group-prepend">
            <span class="input-group-text" id="search-button-navbar">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="16"
                height="16"
                fill="currentColor"
                class="bi bi-search"
                viewBox="0 0 16 16"
              >
                <path
                  d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"
                />
              </svg>
            </span>
          </div>
        </div>
      </form>

      <!--      DropDowns-->
      <ul class="navbar-nav mr-2">
        <li class="nav-item">
          <router-link class="nav-link text-light" :to="{ name: 'Home' }"
            >Home</router-link
          >
        </li>
        <li class="nav-item">
          <router-link class="nav-link text-light" :to="{ name: 'Menu' }"
            >Menu</router-link
          >
        </li>
        <li class="nav-item">
          <router-link class="nav-link text-light" :to="{ name: 'Order' }"
            >Order</router-link
          >
        </li>

        <li class="nav-item dropdown">
          <a
            class="nav-link text-light dropdown-toggle"
            href="#"
            id="navbarDropdown"
            role="button"
            data-toggle="dropdown"
            aria-haspopup="true"
            aria-expanded="false"
          >
            Account
          </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdown">
            <router-link class="dropdown-item" :to="{ name: 'Admin' }"
              >Admin</router-link
            >

            <router-link
              class="dropdown-item"
              v-if="!token"
              :to="{ name: 'Signin' }"
              >Log In</router-link
            >

            <router-link
              class="dropdown-item"
              v-if="!token"
              :to="{ name: 'Signup' }"
              >Sign Up</router-link
            >
            <a class="dropdown-item" v-if="token" href="#" @click="signout"
              >Sign Out</a
            >
          </div>
        </li>

        <li class="nav-item">
          <div id="cart">
            <span class="nav-cart-count badge badge-danger">
              {{ cartCount }}
            </span>
            <router-link class="text-light" :to="{ name: 'Cart' }"
              ><i class="bi bi-cart3" style="font-size: 25px"></i
            ></router-link>
          </div>
        </li>
      </ul>
    </div>
  </nav>
</template>
          
<script>
import swal from "sweetalert";
export default {
  name: "Navbar",
  props: ["cartCount"],
  data() {
    return {
      token: null,
    };
  },
  methods: {
    signout() {
      localStorage.removeItem("token");
      this.token = null;
      this.$emit("resetCartCount");
      this.$router.push({ name: "Home" });
      swal({
        text: "Logged you out. Visit Again",
        icon: "success",
        closeOnClickOutside: false,
      });
    },
  },
  mounted() {
    this.token = localStorage.getItem("token");
  },
};
</script>
          
<style scoped>
#logo {
  width: 120px !important;
  position: absolute;
  top: -12px;
  margin-left: 20px;
  z-index: 1;
}

.input-group > .form-control {
  border-radius: 2px 0 0 2px !important;
}

#search-button-navbar {
  border-top-right-radius: 2px;
  border-bottom-right-radius: 2px;
}
.nav-cart-count {
  position: absolute;
  display: flex;
  align-items: center;
  justify-content: center;

  margin-left: 22px;
}
#cart {
  position: relative;
}

@media screen and (max-width: 992px) {
  .ptop {
    padding-top: 2% !important;
  }
  .dnone {
    display: none;
  }

  #logo {
    margin-left: 10px !important;
  }
}
</style>
          
          