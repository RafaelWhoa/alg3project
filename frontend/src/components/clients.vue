<template>
  <div>
    {{ clients }}
  </div> 
</template>

<script>
import axios from "axios";

export default {
  name:"client",
  data:function(){
    return {
      clients : []
    }
  },
  methods:{
    async search_data(){
      let result = await axios({method:"GET", url:"http://localhost:9090/clients"});
      console.log(result.data)
      this.clients = result.data;
    }
  },
  created(){
    this.search_data();
  }
}
</script>

<style>

</style>