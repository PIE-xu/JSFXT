import request from "@/api/request";

export const add = (data) =>{
    return request({
        url: '/admin/add',
        method:'POST',
        data
    })
}

export const getAdmin = (data) =>{
    return request({
        url: '/admin/getAdmin',
        method:'POST',
        data
    })
}