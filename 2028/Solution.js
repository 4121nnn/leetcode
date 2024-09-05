/**
 * @param {number[]} rolls
 * @param {number} mean
 * @param {number} n
 * @return {number[]}
 */
var missingRolls = function(rolls, mean, n) {
    let dif = (n + rolls.length) * mean;
    for(let i of rolls){
        dif -= i;
    }
    if(dif < n || dif > n * 6) {
        return [];
    }
    let res = new Array(n).fill(Math.floor(dif/n));
    let r = dif % n;
    for(let i = 0; i < r; i++){
        res[i]++;
    }
    return res;
};
