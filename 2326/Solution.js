/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {number} m
 * @param {number} n
 * @param {ListNode} head
 * @return {number[][]}
 */
var spiralMatrix = function(m, n, head) {
    const matrix = Array.from({ length: m }, () => Array(n).fill(-1));

    let topRow = 0, bottomRow = m -1, leftCol = 0, rightCol = n - 1;

    while(head){
        for(let col = leftCol; col <= rightCol && head; col++){
            matrix[topRow][col] = head.val;
            head= head.next;
        }
        topRow++;

        for(let row = topRow; row <= bottomRow && head; row++){
            matrix[row][rightCol] = head.val;
            head = head.next;
        }
        rightCol--;

        for(let col = rightCol; col >= leftCol && head; col--){
            matrix[bottomRow][col] = head.val;
            head= head.next;
        }
        bottomRow--;

        for(let row = bottomRow; row >= topRow && head; row--){
            matrix[row][leftCol] = head.val;
            head = head.next;
        }
        leftCol++;
    }
    return matrix;
};
