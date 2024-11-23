func rotateTheBox(box [][]byte) [][]byte {
    R, C := len(box), len(box[0])
    res := make([][]byte, C)
    for i := 0; i < C; i++ {
        res[i] = make([]byte, R)
        for j := 0; j < R; j++ {
            res[i][j] = '.'
        }
    }
    for r := 0; r < R; r++{
        last := C - 1
        for c := C - 1; c >= 0; c-- {
            if box[r][c] == '#' {
                res[last][R - r - 1] = '#'
                last--
            }else if box[r][c] == '*' {
                last = c - 1
                res[c][R - r - 1] = '*'
            }
        }
    }
    return res
}
