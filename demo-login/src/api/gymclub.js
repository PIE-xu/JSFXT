import request from "@/api/request";

export const getGymById = (id) => {
    return request({
        url: `/gym/${id}`,
        method: 'GET',
    })
}

export const getGymList = (params) => {
    return request({
        url: `/gym/gymList`,
        params
    })
}

export const add = (data) =>{
    return request({
        url: '/gym/add',
        method:'POST',
        data,
    })
}
export const update = (data) =>{
    return request({
        url: '/gym/update',
        method:'POST',
        data
    })
}
export const deleteUser = (data) =>{
    return request({
        url: '/gym/delete',
        method:'DELETE',
        data
    })
}