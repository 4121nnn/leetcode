/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode[]}
 */
var splitListToParts = function(head, k) {
    let res = new Array(k).fill(null);
    let n = 0;
    let cur = head;
    while(cur != null){
        cur = cur.next;
        n++;
    }

    let each = Math.floor(n / k);
    let r = n < k ? 0 : n % k;

    cur = head;
    let i = 0;
    while(cur != null){
        res[i++] = cur;
        let count = 1;
        while(cur != null && count < each){
            cur = cur.next;
            count++;
        }
        if(r > 0){
            r--;
            cur = cur.next;
            if(cur == null) break;
        }
        head = cur.next;
        cur.next = null;
        cur = head;
    }
    return res;

};
