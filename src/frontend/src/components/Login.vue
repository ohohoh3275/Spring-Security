<template>
<div>
id <input type='input'/> <br/>
pw<input type='password'/>
<button type='button' style='width=100px;height=30px;'>Login</button>
</div>
</template>

<script>
import LoginService from '../services/LoginService.js'

export default {
    name : 'Login',
    data(){
        return{
            login : []
        }
    },
    method:{
        getLogin(){
            LoginService.getLogInfo().then( (res) => {
                this.users = res.data;
            })
        }
    },
    created(){
        this.getLogin
    }

}
</script>
