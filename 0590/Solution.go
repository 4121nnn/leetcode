/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Children []*Node
 * }
 */

func postorder(root *Node) []int {
    res := []int{}
    if root == nil {
        return res
    }
    dfs(root, &res)
    return res
}
func dfs(root *Node, res *[]int) {
    for _, child := range root.Children {
        dfs(child, res)
    }
    *res = append(*res, root.Val)
}
