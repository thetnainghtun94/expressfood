<template>
  <div class="container">
    <div class="row">
      <div class="col-12 text-center">
        <h4 class="pt-3">Add New Menu</h4>
      </div>
    </div>

    <div class="row" style="font-family: sans-serif">
      <div class="col-3"></div>
      <div class="col-md-6 px-5 px-md-0">
        <form>
          <div class="form-group">
            <label>Category</label>
            <select class="form-control" v-model="categoryId" required>
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
            <input type="text" class="form-control" v-model="name" required />
          </div>

          <div class="form-group">
            <label>Description</label>
            <input
              type="text"
              class="form-control"
              v-model="description"
              required
            />
          </div>

          <div class="form-group">
            <label>Image</label>
            <input type="url" class="form-control" v-model="image" required />
          </div>

          <div class="form-group">
            <label>Price</label>
            <input
              type="number"
              class="form-control"
              v-model="price"
              required
            />
          </div>
          <div class="text-center">
            <button type="button" class="btn btn-warning" @click="addMenu">
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
      id: null,
      categoryId: null,
      name: null,
      description: null,
      image: null,
      price: null,
    };
  },
  props: ["baseURL", "menus", "categories"],
  methods: {
    async addMenu() {
      const newMenu = {
        id: this.id,
        categoryId: this.categoryId,
        name: this.name,
        description: this.description,
        image: this.image,
        price: this.price,
      };

      await axios({
        method: "post",
        url: this.baseURL + "menu/add",
        data: JSON.stringify(newMenu),
        headers: {
          "Content-Type": "application/json",
        },
      })
        .then((res) => {
          //sending the event to parent to handle
          this.$emit("fetchData");
          this.$router.push({ name: "AdminMenu" });
          swal({
            text: "Menu Added Successfully!",
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
