/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode prev = head, cur = head.next;
        while(cur != null){
            int gcd = gcd(prev.val, cur.val);
            prev.next = new ListNode(gcd, cur);
            prev = cur;
            cur = cur.next;
        }
        return head;
    }

    int gcd(int a, int b){
        while(b!=0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}

// time O(n * log(min(a, b)))
// space O(1)

