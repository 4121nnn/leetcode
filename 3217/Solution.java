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
    public ListNode modifiedList(int[] nums, ListNode head) {
        int max = 0;
        for(int i : nums) if(max < i) max = i;

        boolean[] seen = new boolean[max + 1];
        
        for(int i : nums) seen[i] = true;

        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while(cur.next != null){
            if( cur.next.val <= max && seen[cur.next.val]){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}

// time O(n)
// space O(max)
