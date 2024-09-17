func uncommonFromSentences(s1 string, s2 string) (res []string) {
    list := strings.Split(s1, " ")
    list = append(list, strings.Split(s2, " ")...)
    hm := make(map[string]int)
    
    for _, v := range list {
        hm[v]++
    }

    for k, v := range hm {
        if v == 1 {
            res = append(res, k)
        }
    }
    return

}
