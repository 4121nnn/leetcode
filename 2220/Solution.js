/**
 * @param {number} start
 * @param {number} goal
 * @return {number}
 */
var minBitFlips = function(start, goal) {
    let count = 0;
    let dif = start ^ goal;
    while(dif > 0){
        count += dif & 1;
        dif >>= 1;
    }
    return count;
};
