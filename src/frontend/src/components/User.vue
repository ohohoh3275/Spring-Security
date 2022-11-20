<template>
    <div class = "container">
        <h1 class="text-center"> User List </h1>
    
        <table class="table table-striped">
            <thead>
                <th>User Id</th>
                <th>User First Name</th>
                <th>User Last Name</th>
                <th>User Email</th>
            </thead>

            <tbody>
                <tr v-for="user in users" :key="user.id">
                    <td> {{ user.id }}jk </td>
                    <td> {{ user.firstName }} </td>
                    <td> {{ user.lastName }} </td>
                    <td> {{ user.email }} </td>
                </tr>
            </tbody>
        </table>
    </div>
</template>


<script>
import UserService from '../services/UserService.js'

export default{
    name : 'Users',
    data(){
        return{
            users : []
        }
    },
    method:{
        getUsers(){
            UserService.getUsers().then( (res) => {
                this.users = res.data;
            })
        }
    },
    created(){
        this.getUsers
    }
}
</script>