<template>
  <div class="container" style="font-family: sans-serif">
    <div class="row">
      <div class="col-12 text-center">
        <h4 class="pt-3">Edit Category</h4>
      </div>
    </div>

    <div class="row">
      <div class="col-3"></div>
      <div class="col-md-6 px-5 px-md-0">
        <form v-if="category">
          <div class="form-group">
            <label>Category Name</label>
            <input
              type="text"
              class="form-control"
              v-model="category.categoryName"
              required
            />
          </div>

          <div class="form-group">
            <label>Image</label>
            <input
              type="url"
              class="form-control"
              v-model="category.image"
              required
            />
          </div>
          <div class="text-center">
            <button type="button" class="btn btn-warning" @click="editCategory">
              Submit
            </button>
          </div>
        </form>
      </div>
      <div class="col-3"></div>
    </div>
  </div>
</template>
  
  <script>
export default {
  data() {
    return {
      category: null,
    };
  },
  props: ["baseURL", "categories"],
  methods: {
    async editCategory() {
      delete this.category["menus"];
      await axios
        .post(this.baseURL + "category/update/" + this.id, this.category)
        .then((res) => {
          //sending the event to parent to handle
          this.$emit("fetchData");
          this.$router.push({ name: "AdminCategory" });
          swal({
            text: "Category Updated Successfully!",
            icon: "success",
            closeOnClickOutside: false,
          });
        })
        .catch((err) => console.log(err));
    },
  },
  mounted() {
    if (!localStorage.getItem("token")) {
      this.$router.push({ name: "Signin" });
      return;
    }
    this.id = this.$route.params.id;
    this.category = this.categories.find((category) => category.id == this.id);
    console.log("category", this.category);
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
  