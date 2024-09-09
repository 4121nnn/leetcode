/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func spiralMatrix(m int, n int, head *ListNode) [][]int {
    topRow, rightCol, bottomRow, leftCol := 0, n - 1, m - 1, 0
    matrix := make([][]int, m)

    for i := range matrix {
        matrix[i] = make([]int, n)
        for j := range matrix[i] {
            matrix[i][j] = -1
        }
    }

    for head != nil {
        for i := leftCol; i <= rightCol && head != nil; i++ {
            matrix[topRow][i] = head.Val
            head = head.Next
        }
        topRow++

        for i := topRow; i <= bottomRow && head != nil; i++ {
            matrix[i][rightCol] = head.Val
            head = head.Next
        }
        rightCol--

        for i := rightCol; i >= leftCol && head != nil; i-- {
            matrix[bottomRow][i] = head.Val
            head = head.Next
        }
        bottomRow--

        for i:= bottomRow; i >= topRow && head != nil; i-- {
            matrix[i][leftCol] = head.Val
            head = head.Next
        }
        leftCol++
    }
    return matrix
    
}
