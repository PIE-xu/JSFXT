import request from "@/api/request";

export const getUserList = (params) =>{
    return request({
        url: '/user/userList',
        params
    })
}
export const add = (data) =>{
    return request({
        url: '/user/add',
        method:'POST',
        data
    })
}
export const update = (data) =>{
    return request({
        url: '/user/update',
        method:'POST',
        data
    })
}
export const deleteUser = (data) =>{
    return request({
        url: '/user/delete',
        method:'DELETE',
        data
    })
}