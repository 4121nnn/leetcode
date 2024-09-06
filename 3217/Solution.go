/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func modifiedList(nums []int, head *ListNode) *ListNode {
    max := 0
    for _, num := range nums {
        if max < num {
            max = num
        }
    }
    seen := make([]int, max + 1)

    for _, num := range nums {
        seen[num]++
    }

    temp := &ListNode{Val: 0, Next: head}
    cur := temp
    for cur.Next != nil {
        if cur.Next.Val <= max && seen[cur.Next.Val] > 0{
            cur.Next = cur.Next.Next
        }else{
            cur = cur.Next
        }
    }
    return temp.Next
}
// func modifiedList(nums []int, head *ListNode) *ListNode {
//     seen := make(map[int]bool)
//     for _, num := range nums {
//         seen[num] = true
//     }
//     temp := &ListNode{Val: 0, Next: head}
//     cur := temp
//     for cur.Next != nil {
//         if seen[cur.Next.Val] {
//             cur.Next = cur.Next.Next
//         }else{
//             cur = cur.Next
//         }
//     }
//     return temp.Next
// }
