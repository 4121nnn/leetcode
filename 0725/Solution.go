/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func splitListToParts(head *ListNode, k int) []*ListNode {
    res := make([]*ListNode, k)
    n, r, i := 0, 0, 0
    cur := head
    for cur != nil {
        n++
        cur = cur.Next
    }
    if n > k {
        r = n % k
    }
    x := n / k
    cur = head
    for cur != nil {
        res[i] = cur
        i++
        j := 1
        for cur != nil && j < x {
            j++
            cur = cur.Next
        }
        if r > 0 {
            r--
            cur = cur.Next
            if cur == nil {
                break
            }
        }
        head = cur.Next
        cur.Next = nil
        cur = head
    }
    return res
}
