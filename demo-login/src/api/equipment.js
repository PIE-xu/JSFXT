import request from "@/api/request";

export const getEquipmentByAdminId = (adminId) => {
    return request({
        url: `/equipment/admin/${adminId}`,
        method: 'GET',
    })
}

export const add = (data) =>{
    return request({
        url: '/equipment/add',
        method:'POST',
        data
    })
}

export const update = (data) =>{
    return request({
        url: '/equipment/update',
        method:'POST',
        data
    })
}

export const deleteUser = (data) =>{
    return request({
        url: '/equipment/delete',
        method:'DELETE',
        data
    })
}