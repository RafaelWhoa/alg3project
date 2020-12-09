<template>
  <div>
  <form @submit="onSubmit">
    <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">CPF</label>
    <input type="text" class="form-control" id="cpf" v-model="form.cpf">
  </div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Nome</label>
    <input type="text" class="form-control" id="nome" v-model="form.nome">
  </div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email address</label>
    <input type="email" class="form-control" id="email" v-model="form.email">
  </div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Data de nascimento</label>
    <input type="birthDate" class="form-control" id="birthDate" v-model="form.birthDate">
  </div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Endereço</label>
    <input type="text" class="form-control" id="endereco" v-model="form.endereco">
  </div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Telefone</label>
    <input type="tel" class="form-control" id="phone" v-model="form.phone">
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
      id: this.id,
      form:{
        cpf:'',
        nome: '',
        email:'',
        birthDate: '',
        endereco: '',
        phone: ''
      },
    };

  },
  methods: {
    async onSubmit(event){
      event.preventDefault();
      await axios({method:'POST', url:'http://localhost:9090/alugar/cadastro', data:this.form})
      
    }
  },

  beforeMount(){
    this.id = this.$route.params.id
  },
};
</script>

<style></style>
