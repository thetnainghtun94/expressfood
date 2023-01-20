<template>
  <div class="card h-100 w-100" style="font-family: sans-serif">
    <div class="embed-responsive embed-responsive-16by9">
      <img
        class="card-img-top embed-responsive-item"
        :src="menu.image"
        alt="Menu Image"
      />
    </div>
    <div class="card-body">
      <router-link :to="{ name: 'ShowDetails', params: { id: menu.id } }"
        ><h5 class="card-title text-primary">{{ menu.name }}</h5></router-link
      >
      <p class="card-text"><sup>&#165;</sup>{{ menu.price }}</p>

      <p class="card-text font-italic">
        {{ menu.description.substring(0, 65) }}...
      </p>

      <router-link
        id="edit-menu"
        :to="{ name: 'EditMenu', params: { id: menu.id } }"
        v-show="$route.name == 'AdminMenu'"
      >
        Edit
      </router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: "MenuBox",
  props: ["menu"],
  methods: {
    showDetails() {
      this.$router.push({
        name: "ShowDetails",
        params: { id: this.menu.id },
      });
    },
  },
};
</script>

<style scoped>
.embed-responsive .card-img-top {
  object-fit: cover;
}

a {
  text-decoration: none;
}

.card-title {
  color: #484848;
  font-size: 1.1rem;
  font-weight: 400;
}

.card-title:hover {
  font-weight: bold;
}

.card-text {
  font-size: 0.9rem;
}

#edit-menu {
  float: right;
}
</style>
