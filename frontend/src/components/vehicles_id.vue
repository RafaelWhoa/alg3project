<template>
  <div>
  <form @submit="onSubmit">
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Nome</label>
    <input type="text" class="form-control" id="nome" v-model="form.nome">
  </div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email address</label>
    <input type="email" class="form-control" id="email" v-model="form.email">
  </div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Telefone</label>
    <input type="tel" class="form-control" id="telefone" v-model="form.telefone">
  </div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Data de nascimento</label>
    <input type="date" class="form-control" id="data_nascimento" v-model="form.data_nascimento">
  </div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Endereço</label>
    <input type="text" class="form-control" id="endereco" v-model="form.endereco">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Senha</label>
    <input type="password" class="form-control" id="senha" v-model="form.senha">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
  </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "vehicles_id",
  data: function() {
    return {
      id: null,
      form:{
        nome: '',
        email:'',
        telefone: '',
        data_nascimento: '',
        endereco: '',
        senha:''
      },
    };

  },
  methods: {
    async onSubmit(event){
      event.preventDefault();
      await axios({method:'POST', url:'https://rolinha123.free.beeceptor.com', data:this.form})
      
    }
  },

  beforeMount(){
    this.id = this.$route.params.id
  },
};
</script>

<style></style>
