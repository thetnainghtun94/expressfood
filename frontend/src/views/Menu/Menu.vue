<template>
  <div class="container" style="font-family: sans-serif">
    <div class="row">
      <div class="col-12 text-center">
        <h4 class="pt-3">Our Menus</h4>
        <div class="d-flex justify-content-end">
          <router-link
            class="pr-3"
            :to="{ name: 'AddMenu' }"
            v-show="$route.name == 'AdminMenu'"
          >
            <button class="btn btn-warning">Add a new Menu</button>
          </router-link>

          <router-link
            :to="{ name: 'Gallery' }"
            v-show="$route.name == 'AdminMenu'"
          >
            <button class="btn btn-warning">Gallery</button>
          </router-link>
        </div>
      </div>
    </div>
    <div class="row">
      <div
        v-for="menu of menus"
        :key="menu.id"
        class="col-md-6 col-xl-4 col-12 pt-3 justify-content-around d-flex"
      >
        <MenuBox :menu="menu"> </MenuBox>
      </div>
    </div>
  </div>
</template>

<script>
import MenuBox from "../../components/Menu/MenuBox";
export default {
  name: "Menu",
  components: { MenuBox },
  props: ["baseURL", "menus"],
  mounted() {
    if (this.$route.name == "AdminMenu" && !localStorage.getItem("token")) {
      this.$router.push({ name: "Signin" });
    }
  },
};
</script>

<style scoped>
h4 {
  font-family: "Roboto", sans-serif;
  color: #484848;
  font-weight: 700;
}
</style>
