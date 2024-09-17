/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func pairSum(head *ListNode) (max int) {
    a := make([]int, 0)
    for head != nil {
        a = append(a, head.Val)
        head = head.Next
    }
    l, r := 0, len(a) - 1
    for l < r {
        if a[l] + a[r] > max {
            max = a[l] + a[r]
        }
        l++
        r--
    }
    return 
}
