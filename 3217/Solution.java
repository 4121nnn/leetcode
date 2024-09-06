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
        ListNode dummy = new ListNode(0, head);
        int max = 0;
        for(int i : nums) if(max < i) max = i;

        boolean[] seen = new boolean[max + 1];
        
        for(int i : nums) seen[i] = true;

        ListNode prev = dummy;
        while(head != null){
            while(head != null && head.val <= max && seen[head.val]){
                head = head.next;
            }
            prev.next = head;
            prev = head;
            if(head != null) 
                head = head.next;

        }
        return dummy.next;
    }
}

// time O(n)
// space O(max)
