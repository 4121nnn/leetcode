/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var insertGreatestCommonDivisors = function(head) {
    let prev = head;
    let cur = head.next;
    const findGcd = (a, b) => {
        while(b != 0){
            let temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    while(cur != null){
        let gcd = findGcd(prev.val, cur.val);
        prev.next = new ListNode(gcd, cur);
        prev = cur;
        cur = cur.next;
    } 
    return head;   

};

