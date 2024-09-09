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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int tl = 0, tr = n - 1, br = m - 1, bl = 0;
        int[][] matrix = new int[m][n];

        for(int[] a : matrix) Arrays.fill(a, -1);

        while(head != null){
            for(int i = bl; i <= tr && head != null; i++){
                matrix[tl][i] = head.val;
                head = head.next;
            }
            tl++;

            for(int i = tl; i <= br && head != null; i++){
                matrix[i][tr] = head.val;
                head = head.next;
            }
            tr--;

            for(int i = tr; i >= bl && head != null; i--){
                matrix[br][i] = head.val;
                head = head.next;
            }
            br--;

            for(int i = br; i >= tl && head != null; i--){
                matrix[i][bl] = head.val;
                head = head.next;
            }
            bl++;
        }
        return matrix;
    }
}

// time O(mn)
// space O(1)


