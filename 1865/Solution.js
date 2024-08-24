/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 */
var FindSumPairs = function(nums1, nums2) {
    this.nums1 = nums1;
    this.nums2 = nums2;
    this.hm = new Map();

    for(let i of this.nums2){
        if(this.hm[i] != undefined) this.hm[i]++;
        else this.hm[i] = 1;
    }

};

/** 
 * @param {number} index 
 * @param {number} val
 * @return {void}
 */
FindSumPairs.prototype.add = function(index, val) {
    this.hm[this.nums2[index]]--;
    this.nums2[index] += val;
    if(this.hm[this.nums2[index]] != undefined) this.hm[this.nums2[index]]++;
    else this.hm[this.nums2[index]] = 1;
};

/** 
 * @param {number} tot
 * @return {number}
 */
FindSumPairs.prototype.count = function(tot) {
    let res = 0;
    for(let i of this.nums1){
        const dif = tot - i;
        if(this.hm[dif] != undefined) res += this.hm[dif];
    }
    return res;
};

/** 
 * Your FindSumPairs object will be instantiated and called as such:
 * var obj = new FindSumPairs(nums1, nums2)
 * obj.add(index,val)
 * var param_2 = obj.count(tot)
 */
