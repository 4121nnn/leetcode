func stoneGameII(piles []int) int {
    n := len(piles)
    sufSum := make([]int, n + 1)
    for i := n - 1 ; i >= 0; i--{
        sufSum[i] = sufSum[i+1] + piles[i]
    }
    memo := make([][]int, n)
    for i := range memo{
        memo[i] = make([]int, n + 1)
    }

    var maxStonesAliceCanGet func(int, int) int

    maxStonesAliceCanGet = func(m, i int) int{
        if i >= n { return 0 }
        if i + 2 * m >= n { return sufSum[i] }
        if memo[i][m] != 0 { return memo[i][m] }

        maxStones := 0
        for x := 1; x <= 2*m; x++ {
            curStones := sufSum[i] - maxStonesAliceCanGet(max(x, m) , i + x)
            maxStones = max(maxStones, curStones)
        }
        memo[i][m] = maxStones
        return maxStones
    }

    return maxStonesAliceCanGet(1, 0)

}
func max(a, b int) int{
    if a > b { return a }
    return b
}

