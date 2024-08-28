/**
 * @param {number[]} prices
 * @return {number}
 */
var getDescentPeriods = function(prices) {
    let res = 1;
    let cur = 1;
    for(let i = 1; i < prices.length; i++){
        if(prices[i] == prices[i-1] -1){
            cur++;
        }else{
            cur = 1;
        }
        res += cur;
    }
    return res;
};
