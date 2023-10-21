import { login as loginApi} from "@/api/login"
import router from "@/router";
import {ElMessage} from "element-plus";
export default {
    namespaced:true,
    state: () => ({
        username: localStorage.getItem('username') || ''
    }),
    mutations: {
        setUsername(state,username) {
            state.username = username
            localStorage.setItem('username',username)
        }
    },
    actions: {
        login({commit},userInfo) {
            return new Promise((resolve, reject) =>{
                loginApi(userInfo).then(res =>{
                    if(res.data.username !== null){
                        ElMessage({
                            type: 'success',
                            message: '登录成功',
                        })
                        commit('setUsername',res.data.username)
                        router.replace('/')
                        resolve()
                    } else {
                        ElMessage({
                            type: 'info',
                            message: '账户名或密码错误',
                        })
                    }
                }).catch(err => {
                    reject(err)
                })
            })
        }
    }
}