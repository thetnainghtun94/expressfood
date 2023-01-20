<template>
  <div class="container" style="font-family: sans-serif">
    <div class="row">
      <div class="col-12 text-center">
        <h4 class="pt-3">Our Categories</h4>
        <div class="d-flex justify-content-end">
          <router-link
            class="pr-3"
            :to="{ name: 'AddCategory' }"
            v-show="$route.name == 'AdminCategory'"
          >
            <button class="btn btn-warning">Add a new Category</button>
          </router-link>

          <router-link :to="{ name: 'Gallery' }">
            <button class="btn btn-warning">Gallery</button>
          </router-link>
        </div>
      </div>
    </div>
    <div class="row">
      <div
        v-for="category of categories"
        :key="category.id"
        class="col-md-6 col-xl-4 col-12 pt-3 justify-content-around d-flex"
      >
        <CategoryBox :category="category"> </CategoryBox>
      </div>
    </div>
  </div>
</template>

<script>
import CategoryBox from "../../components/Category/CategoryBox";

export default {
  name: "Category",
  components: { CategoryBox },
  props: ["baseURL", "categories"],
  mounted() {
    if (this.$route.name == "AdminCategory" && !localStorage.getItem("token")) {
      this.$router.push({ name: "Signin" });
    }
  },
};
</script>

<style>
</style>