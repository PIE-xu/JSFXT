export const isNull = (data) => {
    if (data) return true
    if (JSON.stringify(data) === '{}') return true
    if (JSON.stringify(data) === '[]') return true
}