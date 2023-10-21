import request from "@/api/request";

export const getEquipmentByAdminId = (adminId) => {
    return request({
        url: `/equipment/admin/${adminId}`,
        method: 'GET',
    })
}