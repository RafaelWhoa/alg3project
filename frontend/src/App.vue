<template>
  <div class="container">
    <vehicles/>
  </div>
</template>

<script>
import Vehicles from './components/vehicles.vue'


export default {
  name: 'App',
  components: {
    Vehicles
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
