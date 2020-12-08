<template>
  <div>
    <h1>TESTADO</h1>
  </div>
</template>

<script>

export default {
  name: "vehicles_id",
  data: function() {
    return {
      id: null,
    };
  },
  methods: {},

  beforeMount(){
    this.id = this.$route.params.id
  },
  created() {
  },
};
</script>

<style></style>
