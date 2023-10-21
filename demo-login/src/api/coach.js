import request from "@/api/request";

export const getCoachByAdminId = (adminId) => {
    return request({
        url: `/coach/admin/${adminId}`,
        method: 'GET',
    })
}

export const add = (data) =>{
    return request({
        url: '/coach/add',
        method:'POST',
        data
    })
}

export const update = (data) =>{
    return request({
        url: '/coach/update',
        method:'POST',
        data
    })
}

export const deleteUser = (data) =>{
    return request({
        url: '/coach/delete',
        method:'DELETE',
        data
    })
}