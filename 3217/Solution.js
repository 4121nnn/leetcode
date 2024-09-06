/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {number[]} nums
 * @param {ListNode} head
 * @return {ListNode}
 */
var modifiedList = function(nums, head) {
    let max = 0;
    for(let num of nums) if(max < num) max = num;
    let seen = new Array(max + 1).fill(0);
    for(let num of nums) seen[num]++;
    
};
