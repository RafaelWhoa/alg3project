<template>
  <div>
    <select
      class="form-select"
      size="10"
      aria-label="multiple select example"
      v-model="selected"
    >
      <option
        v-for="vehicle in vehicles"
        :key="vehicle.id"
        :value="vehicle"
        >Carro:{{ vehicle.manufacturer }} Modelo:
        {{ vehicle.model }} Categoria:{{ vehicle.category }}</option
      >
    </select>
    <br />
    <br />
    <span>{{ selected?.pricePerDay ?? 0 }}</span>
    <br />
    
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "vehicles",
  data: function() {
    return {
      vehicles: [],
      selected: null,
    };
  },
  methods: {
    async search_data() {
      let result = await axios({
        method: "GET",
        url: "http://localhost:9090/vehicles",
      });
      console.log(result.data);
      this.vehicles = result.data;
    },  
    async id_car() {
      axios.post("/id", {
        firstName: this.selected.id,
      });
    },
  },
  created() {
    this.search_data();
  },
};
</script>

<style></style>
