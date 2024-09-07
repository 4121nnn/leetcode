/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isSubPath(head *ListNode, root *TreeNode) bool {
    if root == nil {
        return false
    }
    if checkForPath(head, root) {
        return true
    }
    return isSubPath(head, root.Left) || isSubPath(head, root.Right)
}

func checkForPath(head *ListNode, root *TreeNode) bool {
    if head == nil {
        return true
    }
    if root == nil || head.Val != root.Val {
        return false
    }
    return checkForPath(head.Next, root.Left) || checkForPath(head.Next, root.Right)
}
