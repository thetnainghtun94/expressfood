<template>
  <div class="container" style="font-family: sans-serif">
    <div class="row pt-5">
      <div class="col-md-1"></div>
      <div class="col-md-4 col-12">
        <img :src="menu.image" :alt="menu.name" class="img-fluid" />
      </div>
      <div class="col-md-6 col-12 pt-3 pt-md-0">
        <h4>{{ menu.name }}</h4>
        <h6 class="category font-italic">{{ category.categoryName }}</h6>
        <h6 class="font-weight-bold">&#165; {{ menu.price }}</h6>
        <p>
          {{ menu.description }}
        </p>

        <div class="row d-flex flex-row justify-content-start pl-3">
          <p class="pr-3 pt-1">Quantity</p>
          <div :v-model="quantity">
            <button
              :disabled="isActive"
              class="btn btn-sm mr-2"
              @click="decreaseQty(menu.id)"
            >
              &#8722;</button
            ><span class="text-danger">{{ quantity }}</span>
            <button class="btn btn-sm ml-2" @click="increaseQty(menu.id)">
              &#43;
            </button>
          </div>
        </div>

        <div class="row d-flex flex-row p-3">
          <button
            type="button"
            id="add-to-cart-button"
            class="btn mr-3"
            @click="addToCart(this.id)"
          >
            Add to Cart
            <ion-icon name="cart-outline" v-pre></ion-icon>
          </button>

          <button
            id="show-cart-button"
            type="button"
            class="btn mr-3 p-1 py-0 rounded"
            @click="listCartItems()"
          >
            Show Cart

            <ion-icon name="cart-outline" v-pre></ion-icon>
          </button>
        </div>
      </div>
      <div class="col-md-1"></div>
    </div>
  </div>
</template>

<script>
import { is } from "@babel/types";

export default {
  data() {
    return {
      menu: {},
      category: {},
      id: null,
      token: null,
      quantity: 1,
      isActive: false,
    };
  },
  props: ["baseURL", "menus", "categories"],
  methods: {
    increaseQty() {
      this.quantity++;
    },

    decreaseQty() {
      this.quantity--;
      if (this.quantity === 1) {
        this.isActive;
      }
    },

    addToCart(menuId) {
      if (!this.token) {
        swal({
          text: "Please log in first!",
          icon: "error",
        });
        return;
      }
      axios
        .post(`${this.baseURL}cart/add?token=${this.token}`, {
          menuId: menuId,
          quantity: this.quantity,
        })
        .then(
          (response) => {
            if (response.status == 201) {
              swal({
                text: "Menu Added to the cart!",
                icon: "success",
                closeOnClickOutside: false,
              });
              // refresh nav bar
              this.$emit("fetchData");
            }
          },
          (error) => {
            console.log(error);
          }
        );
    },

    listCartItems() {
      axios.get(`${this.baseURL}cart/?token=${this.token}`).then(
        (response) => {
          if (response.status === 200) {
            this.$router.push("/cart");
          }
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
  mounted() {
    this.id = this.$route.params.id;
    this.menu = this.menus.find((menu) => menu.id == this.id);
    this.category = this.categories.find(
      (category) => category.id == this.menu.categoryId
    );
    this.token = localStorage.getItem("token");
  },
};
</script>

<style>
.category {
  font-weight: 400;
}

/* Chrome, Safari, Edge, Opera */
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}

/* Firefox */
/* input[type="number"] {
  -moz-appearance: textfield;
} */

#add-to-cart-button {
  background-color: #febd69;
}

#wishlist-button {
  background-color: #b9b9b9;
  border-radius: 0;
}

#show-cart-button {
  background-color: #131921;
  color: white;
  border-radius: 0;
}
</style>
