<template>
  <Navbar
    :cartCount="cartCount"
    @resetCartCount="resetCartCount"
    v-if="!['Signup', 'Signin'].includes($route.name)"
  />
  <div style="min-height: 60vh">
    <router-view
      v-if="menus && categories"
      :baseURL="baseURL"
      :menus="menus"
      :categories="categories"
      @fetchData="fetchData"
    >
    </router-view>
  </div>
  <Footer></Footer>
</template>

<script>
import Navbar from "./components/Navbar.vue";
import Footer from "./components/Footer.vue";
export default {
  data() {
    return {
      baseURL: "http://localhost:8081/",
      users: null,
      menus: null,
      categories: null,
      key: 0,
      token: null,
      cartCount: 0,
    };
  },

  components: { Navbar, Footer },
  methods: {
    async fetchData() {
      //fetch users
      // await axios
      //   .get(this.baseURL + "user/profile")
      //   .then((res) => (this.users = res.data))
      //   .catch((err) => console.log(err));

      // fetch menus
      await axios
        .get(this.baseURL + "menu/")
        .then((res) => (this.menus = res.data))
        .catch((err) => console.log(err));

      //fetch categories
      await axios
        .get(this.baseURL + "category/")
        .then((res) => (this.categories = res.data))
        .catch((err) => console.log(err));

      //fetch cart items
      if (this.token) {
        await axios.get(`${this.baseURL}cart/?token=${this.token}`).then(
          (response) => {
            if (response.status == 200) {
              // update cart
              this.cartCount = Object.keys(response.data.cartItems).length;
            }
          },
          (error) => {
            console.log(error);
          }
        );
      }
    },
    resetCartCount() {
      this.cartCount = 0;
    },
  },
  mounted() {
    this.token = localStorage.getItem("token");
    this.fetchData();
  },
};
</script>

<style>
/* html {
  overflow-y: scroll;
} */
</style>
