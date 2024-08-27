func maxProbability(n int, edges [][]int, succProb []float64, start_node int, end_node int) float64 {
    max := make([]float64, n)
    max[start_node] = 1.0
    for i:=0; i< n-1; i++{
        updated := false
        for j:=0; j< len(edges); j++{
            u, v, prob := edges[j][0], edges[j][1], succProb[j]
            if max[u] * prob > max[v] {
                max[v] = max[u] * prob
                updated = true
            }
            if max[v] * prob > max[u] {
                max[u] = max[v] * prob
                updated = true
            }
        }
        if !updated {
            break
        }
    }
    return max[end_node]
}
