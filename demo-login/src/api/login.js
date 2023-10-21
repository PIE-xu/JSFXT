import request from "@/api/request";

export const login = (data) =>{
    return request({
        url: '/admin/login',
        method:'POST',
        data
    })
}