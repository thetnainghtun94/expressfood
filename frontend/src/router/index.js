import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home.vue";

import Admin from "../views/Admin/Admin.vue";
import Gallery from "../views/Admin/Gallery.vue";
import AddImage from "../views/Admin/AddImage.vue";

import Menu from "../views/Menu/Menu.vue";
import AddMenu from "../views/Menu/AddMenu.vue";
import EditMenu from "../views/Menu/EditMenu.vue";
import ShowDetails from "../views/Menu/ShowDetails.vue";

import Cart from "../views/Cart/Cart.vue";
import Checkout from "../views/Checkout/Checkout.vue";
import Order from "../views/Orders/Order.vue";
import OrderDetails from "../views/Orders/OrderDetails";

import Category from "../views/Category/Category.vue";
import AddCategory from "../views/Category/AddCategory.vue";
import EditCategory from "../views/Category/EditCategory.vue";
// import ListMenus from "../views/Category/ListMenus.vue";

import Signup from "../views/Signup.vue";
import Signin from "../views/Signin.vue";

import Success from "../helper/payment/Success.vue";
import Failed from "../helper/payment/Failed.vue";

import PageNotFound from "../views/PageNotFound.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  // {
  //   path: "/dashboard",
  //   name: "Dashboard",
  //   component: Dashboard,
  // },
  //Signin and Signup
  {
    path: "/signup",
    name: "Signup",
    component: Signup,
  },
  {
    path: "/signin",
    name: "Signin",
    component: Signin,
  },
  //Admin
  {
    path: "/admin",
    name: "Admin",
    component: Admin,
  },
  {
    path: "/admin/gallery",
    name: "Gallery",
    component: Gallery,
  },
  {
    path: "/admin/gallery/add",
    name: "AddImage",
    component: AddImage,
  },

  //Category routes
  {
    path: "/category",
    name: "Category",
    component: Category,
  },
  {
    path: "/admin/category",
    name: "AdminCategory",
    component: Category,
  },
  {
    path: "/admin/category/add",
    name: "AddCategory",
    component: AddCategory,
  },
  {
    path: "/admin/category/:id",
    name: "EditCategory",
    component: EditCategory,
  },
  // {
  //   path: "/category/show/:id",
  //   name: "ListMenus",
  //   component: ListMenus,
  // },
  //Menu routes
  {
    path: "/menu",
    name: "Menu",
    component: Menu,
  },
  {
    path: "/admin/menu",
    name: "AdminMenu",
    component: Menu,
  },
  {
    path: "/admin/menu/add",
    name: "AddMenu",
    component: AddMenu,
  },
  {
    path: "/admin/menu/:id",
    name: "EditMenu",
    component: EditMenu,
  },
  {
    path: "/menu/show/:id",
    name: "ShowDetails",
    component: ShowDetails,
  },

  {
    path: "/cart",
    name: "Cart",
    component: Cart,
  },
  {
    path: "/checkout",
    name: "Checkout",
    component: Checkout,
  },
  {
    path: "/payment/success",
    name: "PaymentSuccess",
    component: Success,
  },
  {
    path: "/payment/failed",
    name: "FailedPayment",
    component: Failed,
  },
  {
    path: "/order",
    name: "Order",
    component: Order,
  },
  {
    path: "/order/:id",
    name: "OrderDetails",
    component: OrderDetails,
  },
  {
    path: "/:catchAll(.*)",
    name: "PageNotFound",
    component: PageNotFound,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

//scroll to top after every route change
router.beforeEach((to, from, next) => {
  window.scrollTo(0, 0);
  next();
});

export default router;
