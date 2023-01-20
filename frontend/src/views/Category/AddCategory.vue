<template>
  <div class="container">
    <div class="row">
      <div class="col-12 text-center">
        <h4 class="pt-3">Add new Category</h4>
      </div>
    </div>

    <div class="row" style="font-family: sans-serif">
      <div class="col-3"></div>
      <div class="col-md-6 px-5 px-md-0">
        <form>
          <div class="form-group">
            <label>Category Name</label>
            <input
              type="text"
              class="form-control"
              v-model="categoryName"
              required
            />
          </div>

          <div class="form-group">
            <label>Image</label>
            <input type="url" class="form-control" v-model="image" required />
          </div>
          <div class="text-center">
            <button type="button" class="btn btn-warning" @click="addCategory">
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
      categoryName: null,
      image: null,
    };
  },
  props: ["baseURL", "categories"],
  methods: {
    async addCategory() {
      const newCategory = {
        categoryName: this.categoryName,
        image: this.image,
      };

      await axios({
        method: "post",
        url: this.baseURL + "category/create",
        data: JSON.stringify(newCategory),
        headers: {
          "Content-Type": "application/json",
        },
      })
        .then((res) => {
          //sending the event to parent to handle
          this.$emit("fetchData");
          this.$router.push({ name: "AdminCategory" });
          swal({
            text: "Category Added Successfully!",
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
 