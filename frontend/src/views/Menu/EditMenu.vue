<template>
  <div class="container" style="font-family: sans-serif">
    <div class="row">
      <div class="col-12 text-center">
        <h4 class="pt-3">Edit Menu</h4>
      </div>
    </div>

    <div class="row">
      <div class="col-3"></div>
      <div class="col-md-6 px-5 px-md-0">
        <form v-if="menu">
          <div class="form-group">
            <label>Category</label>
            <select class="form-control" v-model="menu.categoryId" required>
              <option
                v-for="category of categories"
                :key="category.id"
                :value="category.id"
              >
                {{ category.categoryName }}
              </option>
            </select>
          </div>
          <div class="form-group">
            <label>Name</label>
            <input
              type="text"
              class="form-control"
              v-model="menu.name"
              required
            />
          </div>
          <div class="form-group">
            <label>Description</label>
            <input
              type="text"
              class="form-control"
              v-model="menu.description"
              required
            />
          </div>
          <div class="form-group">
            <label>Image</label>
            <input
              type="url"
              class="form-control"
              v-model="menu.image"
              required
            />
          </div>
          <div class="form-group">
            <label>Price</label>
            <input
              type="number"
              class="form-control"
              v-model="menu.price"
              required
            />
          </div>
          <div class="text-center">
            <button type="button" class="btn btn-warning" @click="editMenu">
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
      menu: null,
    };
  },
  props: ["baseURL", "menus", "categories"],
  methods: {
    async editMenu() {
      axios
        .post(this.baseURL + "menu/update/" + this.id, this.menu)
        .then((res) => {
          //sending the event to parent to handle
          this.$emit("fetchData");
          this.$router.push({ name: "AdminMenu" });
          swal({
            text: "Menu Updated Successfully!",
            icon: "success",
            closeOnClickOutside: false,
          });
        })
        .catch((err) => console.log("err", err));
    },
  },
  mounted() {
    if (!localStorage.getItem("token")) {
      this.$router.push({ name: "Signin" });
      return;
    }
    this.id = this.$route.params.id;
    this.menu = this.menus.find((menu) => menu.id == this.id);
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
