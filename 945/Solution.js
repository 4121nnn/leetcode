/**
 * @param {number[]} nums
 * @return {number}
 */
var minIncrementForUnique = function(nums) {
    let  max = 0;
    for(let i = 0; i < nums.length; i++) if(nums[i] > max) max = nums[i];
    let map = Array(max + 1 + nums.length).fill(0);
    for(let i = 0; i < nums.length; i++) map[nums[i]]++;
    let res = 0;
    for(let i = 0; i < map.length; i++){
        if(map[i] > 1){
            res += map[i] - 1;
            map[i + 1] += map[i] -1;
        }
    }
    return res;
};
