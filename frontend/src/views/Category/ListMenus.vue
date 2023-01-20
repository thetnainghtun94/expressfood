<template>
  <div class="container">
    <div class="row">
      <div class="col-12 text-center">
        <h4 class="pt-3">{{ category.categoryName }}</h4>
        <h5>{{ msg }}</h5>
      </div>
    </div>

    <div class="row">
      <img
        v-show="length == 0"
        class="img-fluid"
        src="../../assets/sorry.jpg"
        alt="Sorry"
      />
      <div
        v-for="menu of category.menus"
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
  name: "ListMenus",
  data() {
    return {
      id: null,
      categoryIndex: null,
      category: {},
      len: 0,
      msg: null,
    };
  },
  components: { MenuBox },
  props: ["baseURL", "categories"],
  mounted() {
    this.id = this.$route.params.id;
    this.categoryIndex = this.categories.findIndex(
      (category) => category.id == this.id
    );
    this.category = this.categories[this.categoryIndex];

    this.len = this.category.menus.length;
    if (this.len == 0) {
      this.msg = "Sorry, no menus found";
    } else if (this.len == 1) {
      this.msg = "Only 1 menus found";
    } else {
      this.msg = this.len + " menus found";
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

h5 {
  font-family: "Roboto", sans-serif;
  color: #686868;
  font-weight: 300;
}
</style>
  