<template>
  <div class="div_class">
    <h3>You will be redirected to payment page</h3>

    <!-- <div
      v-for="(user, id) in users"
      :key="id"
      class="alert alert-primary"
      role="alert"
    >
      <p>{{ user.name }}</p>
    </div> -->

    <button
      class="checkout_button btn btn-warning font-weight-bold text-dark"
      id="proceed-to-checkout"
      @click="goToCheckout()"
    >
      Make Payment
    </button>
  </div>
</template>
  <script>
export default {
  data() {
    return {
      stripeAPIToken:
        "pk_test_51MGnZIB3OGPZFt8njGxJsV2cFN6nq3Jx7c9WJOJq6xsxxyQJtISFeuzQZ3tgb8kY3PJxsGDmGYivYVZYaX6GdyEs00Xp8z2axF",
      stripe: "",
      token: null,
      sessionId: null,
      checkoutBodyArray: [],
    };
  },

  name: "Checkout",
  props: ["baseURL"],
  methods: {
    /*
        Configures Stripe by setting up the elements and
        creating the card element.
      */
    configureStripe() {},

    getAllItems() {
      axios.get(`${this.baseURL}cart/?token=${this.token}`).then(
        (response) => {
          if (response.status == 200) {
            let menus = response.data;
            let len = Object.keys(menus.cartItems).length;
            for (let i = 0; i < len; i++)
              this.checkoutBodyArray.push({
                image: menus.cartItems[i].menu.image,
                menuName: menus.cartItems[i].menu.name,
                quantity: menus.cartItems[i].quantity,
                price: menus.cartItems[i].menu.price,
                menuId: menus.cartItems[i].menu.id,
                userId: menus.cartItems[i].userId,
              });
          }
        },
        (err) => {
          console.log(err);
        }
      );
    },

    goToCheckout() {
      axios
        .post(
          this.baseURL + "order/create-checkout-session",
          this.checkoutBodyArray
        )
        .then((response) => {
          localStorage.setItem("sessionId", response.data.sessionId);
          return response.data;
        })
        .then((session) => {
          return this.stripe.redirectToCheckout({
            sessionId: session.sessionId,
          });
        });
    },
  },
  mounted() {
    // get the token
    this.token = localStorage.getItem("token");
    // get all the cart items
    this.stripe = Stripe(this.stripeAPIToken);
    this.getAllItems();
  },
};
</script>
  
  <style>
.alert {
  width: 50%;
}

.div_class {
  margin-top: 5%;
  margin-left: 30%;
}

.checkout_button {
  border: none;
  color: white;
  margin-left: 15%;
  padding: 15px 30px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 15px;
  font-weight: bold;
  border-radius: 15px;
}

.checkout_button:focus {
  outline: none;
  box-shadow: none;
}

.checkout_button:disabled {
  background-color: #9b86f7;
  border: none;
  color: white;
  margin-left: 15%;
  padding: 15px 30px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 15px;
  font-weight: bold;
  border-radius: 15px;
  cursor: not-allowed;
}
</style>
  