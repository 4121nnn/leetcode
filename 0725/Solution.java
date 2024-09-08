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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        ListNode cur = head;
        int n = 0;
        while(cur != null){
            cur = cur.next;
            n++;
        }
        int each = n / k;
        int r = n > k ? n % k : 0;
        
        cur = head;
        int i = 0;

        while(cur != null){
            res[i++] = cur;
            int count = 1;
            
            while(cur != null && count++ < each) cur = cur.next;
            if(r-- > 0) cur = cur.next;
                        
            head = cur.next;
            cur.next = null;
            cur = head;

        }
        return res;
    }
}

// time O(n)
// space O(1)
