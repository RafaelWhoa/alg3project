import { createRouter, createWebHistory } from 'vue-router'
import Home from '../components/clients.vue'
import Aluga from '../components/vehicles.vue'
import Select from '../components/vehicles_id.vue'



const routes = [
  {
    path: '/',
    name: 'teste',
    component: Home
  },
  {

    path: '/alugar',
    name: 'Alugar',
    component: Aluga
  },
  {
    path: '/alugar/cadastro', component: Select,
    name: 'id'
  }
  
]


const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
