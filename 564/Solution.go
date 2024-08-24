func nearestPalindromic(n string) string {
    num, _ := strconv.ParseInt(n, 10, 64)
    if num <= 10 { return strconv.FormatInt(num - 1 , 10) }
    if num == 11 { return "9" }

    length := len(n)
    half, _ := strconv.ParseInt(n[:(length + 1)/2], 10, 64)

    var cands [5]int64

    cands[0] = genPalFromHalf(half, length % 2 == 0)
    cands[1] = genPalFromHalf(half-1, length % 2 == 0)
    cands[2] = genPalFromHalf(half+1, length % 2 == 0)
    cands[3] = int64(math.Pow10(length)) + 1
    cands[4] = int64(math.Pow10(length - 1)) -1;

    minDif := int64(math.MaxInt64)
    var res int64

    for _, cand := range cands{
        if cand == num { continue }
        dif := int64(math.Abs(float64(cand - num)))
        if dif < minDif || (dif == minDif && cand < res){
            res = cand
            minDif = dif
        }
    }

    return strconv.FormatInt(res, 10)

}

func genPalFromHalf(half int64, even bool) int64 {
    res := half
    if !even { half /= 10 }
    for half > 0 {
        res = res * 10 + half % 10
        half /= 10
    }
    return res
}
