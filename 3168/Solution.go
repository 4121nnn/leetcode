func minimumChairs(s string) int {
    count, max := 0, 0
    for _, c := range s{
        if c == 'E'{
            count++
        }else{
            count--
        }
        if count > max {
            max = count
        }
    }
    return max
}
