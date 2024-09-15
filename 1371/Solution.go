func findTheLongestSubstring(s string) int {
    mask, res := 0, 0
    hm := make([]int, 32)
    for i := range hm {
        hm[i] = -2
    }
    hm[0] = -1
    for i, c := range s {
        switch c {
            case 'a': mask ^= 1
            case 'e': mask ^= 2
            case 'i': mask ^= 4
            case 'o': mask ^= 8
            case 'u': mask ^= 16
        }
        if hm[mask] != -2 {
            if i - hm[mask] > res {
                res = i - hm[mask]
            }
        }else{
            hm[mask] = i
        }
    }
    return res
}
