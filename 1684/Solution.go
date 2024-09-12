func countConsistentStrings(allowed string, words []string) int {
    charMap := make([]bool, 26)
    for _, c := range allowed {
        charMap[c - 'a'] = true
    }
    count := 0
    for _, s:= range words {
        if isAllowed(s, charMap) {
            count++
        }
    }
    return count
}
func isAllowed(s string, charMap []bool) bool {
    for _, c := range s {
        if !charMap[c - 'a'] {
            return false
        }
    }
    return true
}
