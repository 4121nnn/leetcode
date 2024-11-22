func maxEqualRowsAfterFlips(matrix [][]int) int {
    hm := make(map[string]int)

    for _, r := range matrix {
        key := make([]byte, len(r))
        for i, n := range r{
            if r[0] == 1{
                key[i] = byte('0' + (1 - n))
            }else{
                key[i] = byte('0' + n)
            }
        }
        hm[string(key)]++
    }

    res := 0
    for _, v := range hm {
        res = max(res, v)
    }
    return res
}
