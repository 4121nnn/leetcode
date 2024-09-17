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
    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        int max = 0, n = list.size();
        
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        
        for(int i = 0; i < n; i++){
            max = Math.max(max, list.get(i) + list.get(n - i - 1));
        } 
        return max;
    }
}
