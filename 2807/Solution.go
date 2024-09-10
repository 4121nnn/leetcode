/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func insertGreatestCommonDivisors(head *ListNode) *ListNode {
    prev, cur := head, head.Next

    for cur != nil {
        gcd := findGcd(prev.Val, cur.Val)
        prev.Next = &ListNode{Val: gcd, Next: cur}
        prev = cur
        cur = cur.Next
    }
    return head
}
func findGcd(a, b int) int {
    for b != 0 {
        temp := a % b
        a = b
        b = temp
    }
    return a
}
