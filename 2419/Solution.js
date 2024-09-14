/**
 * @param {number[]} nums
 * @return {number}
 */
var longestSubarray = function(nums) {
    let max = 0;
    let cur = 0;
    let res = 0;
    for(let i of nums){
        max = Math.max(max, i);
    }
    for(let i of nums){
        if(i == max){
            cur++;
            res = Math.max(res, cur);
        }else{
            cur = 0;
        }
    }
    return res;
};
