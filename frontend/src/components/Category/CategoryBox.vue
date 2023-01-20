<template>
  <div class="card h-100 w-100" style="font-family: sans-serif">
    <div class="embed-responsive embed-responsive-16by9">
      <img
        class="card-img-top embed-responsive-item"
        :src="category.image"
        alt="Category Image"
      />
    </div>

    <div class="card-body">
      <router-link to=""
        ><h5 class="card-title">{{ category.categoryName }}</h5></router-link
      >

      <router-link
        id="edit-category"
        :to="{ name: 'EditCategory', params: { id: category.id } }"
        v-show="$route.name == 'AdminCategory'"
      >
        Edit
      </router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: "CategoryBox",
  props: ["category"],
  methods: {
    listMenus() {
      this.$router.push({
        name: "ListMenus",
        params: { id: this.category.id },
      });
    },
  },
};
</script>

<style>
</style>