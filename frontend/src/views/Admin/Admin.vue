<template>
  <div class="container" style="font-family: sans-serif">
    <h2 class="text-center py-5" style="font-family: sans-serif">
      Admin Dashboard
    </h2>
    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-4 text-center">
      <div class="col">
        <router-link
          class="btn btn-warning fontsize"
          :to="{ name: 'AdminMenu' }"
          >Admin Menus</router-link
        >
      </div>
      <div class="col">
        <router-link
          class="btn btn-warning fontsize"
          :to="{ name: 'AdminCategory' }"
          >Admin Categories</router-link
        >
      </div>
      <div class="col">
        <router-link class="btn btn-warning fontsize" :to="{ name: 'Gallery' }"
          >Admin Galleries</router-link
        >
      </div>
      <div class="col">
        <router-link class="btn btn-warning fontsize" to=""
          >Admin Orders</router-link
        >
      </div>
    </div>
  </div>
</template>
  
  <script>
export default {
  mounted() {
    if (!localStorage.getItem("token")) {
      this.$router.push({ name: "Signin" });
    }
  },
};
</script>
  
<style>
/* .adminPanel {
  display: flex;
  flex-direction: column;
  align-items: center;
}
.adminPanel button {
  font-size: 30px;
  width: fit-content;
  margin: 55px 0;
} */
.fontsize {
  font-size: 1.5rem;
  padding: 8% 10%;
}
</style>