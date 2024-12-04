func canMakeSubsequence(str1 string, str2 string) bool {
    i, j := 0, 0
    for i < len(str1) && j < len(str2) {
        x := str1[i] + 1
        if str1[i] == 'z' {
            x = 'a'
        }

        if str1[i] == str2[j] || str2[j] == x {
            i++
            j++
        }else {
            i++
        }
    }
    return j == len(str2)

}
