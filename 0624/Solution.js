/**
 * @param {number[][]} arrays
 * @return {number}
 */
var maxDistance = function(arrays) {
    let min = arrays[0][0]
    let max = arrays[0][arrays[0].length - 1]
    let res = 0
    for(let i = 1; i < arrays.length; i++){
        let curMin = arrays[i][0]
        let curMax = arrays[i][arrays[i].length - 1]

        res = Math.max(res, Math.max(curMax - min, max - curMin))
        min = Math.min(min, curMin)
        max = Math.max(max, curMax)
    }
    return res
};
