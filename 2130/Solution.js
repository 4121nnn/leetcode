/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {number}
 */
var pairSum = function(head) {
    let a = [];
    while(head != null){
        a.push(head.val);
        head = head.next;
    }
    let max = 0;
    let l = 0;
    let r = a.length-1;
    while(l < r){
        max = Math.max(max, a[l++] + a[r--]);
    }
    return max;
};
