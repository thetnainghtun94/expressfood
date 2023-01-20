<template>
  <div id="home">
    <div
      id="carouselExampleControls"
      class="carousel slide"
      data-ride="carousel"
    >
      <div class="carousel-inner">
        <div class="carousel-item active">
          <img class="img1 d-block w-100" />
        </div>
        <div class="carousel-item">
          <img class="img2 d-block w-100" />
        </div>
        <div class="carousel-item">
          <img class="img3 d-block w-100" />
        </div>
      </div>
      <a
        class="carousel-control-prev"
        href="#carouselExampleControls"
        role="button"
        data-slide="prev"
      >
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a
        class="carousel-control-next"
        href="#carouselExampleControls"
        role="button"
        data-slide="next"
      >
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>

    <div id="start-shopping" class="container pb-2">
      <div class="row">
        <div class="col-12 text-left">
          <h2 class="pt-4" style="font-family: sans-serif">Top Categories</h2>
        </div>
      </div>
      <div class="row">
        <div
          v-for="index in this.category_size"
          :key="index"
          class="col-md-6 col-xl-4 col-12 pt-3 justify-content-around d-flex"
        >
          <CategoryBox :category="categories[index - 1]"> </CategoryBox>
        </div>
      </div>
    </div>

    <hr />
    <div class="container">
      <div class="row">
        <div class="col-12 text-left">
          <h2 class="pt-3" style="font-family: sans-serif">Top menus</h2>
        </div>
      </div>
      <div class="row">
        <div
          v-for="index in this.menu_size"
          :key="index"
          class="col-md-6 col-xl-4 col-12 pt-3 justify-content-around d-flex"
        >
          <MenuBox :menu="menus[index - 1]"> </MenuBox>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import MenuBox from "../components/Menu/MenuBox";
import CategoryBox from "../components/Category/CategoryBox";
export default {
  name: "Home",
  components: { MenuBox, CategoryBox },
  props: ["baseURL", "menus", "categories"],
  data() {
    return {
      category_size: 0,
      menu_size: 0,
    };
  },
  mounted() {
    this.category_size = this.categories.length;
    this.category_size = Math.min(6, this.category_size);

    this.menu_size = this.menus.length;
    this.menu_size = Math.min(9, this.menu_size);
  },
};
</script>

<style>
.page-holder {
  min-height: 100vh;
}
.slider.slider-horizontal {
  width: 400px;
}

#heading {
  text-decoration: none;
  font-family: "Roboto", sans-serif;
  font-weight: 400;
  opacity: 0.8;
  font-family: "Josefin Sans", sans-serif;
}

#content {
  opacity: 0.8;
}

h2 {
  font-family: "Josefin Sans", sans-serif;
}

.lead {
  font-style: italic;
  font-size: xx-large;
}

.carousel-item img {
  height: 90vh;
}

.carousel .img1 {
  background-image: url("../assets/foodbanner1.png");
  /* background-size: cover; */
}

.carousel .img2 {
  background-image: url("../assets/foodbanner2.webp");
  background-size: contain;
}

.carousel .img3 {
  background-image: url("../assets/foodbanner3.jpg");
  background-size: contain;
}

@media screen and (max-width: 780px) {
  .carousel-item img {
    height: 75vh;
  }

  .carousel .img1 {
    background-image: url("../assets/foodbanner1.png");
    background-size: cover;
  }

  .carousel .img2 {
    background-image: url("../assets/foodbanner2.webp");
    background-size: cover;
  }

  .carousel .img3 {
    background-image: url("../assets/foodbanner3.jpg");
    background-size: cover;
  }
}
</style>
