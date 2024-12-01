func checkIfExist(arr []int) bool {
    mp := make(map[int]int)
    for i := range arr{
        mp[arr[i]]++
    }
    for i := range arr {
        if mp[arr[i] * 2] > 0{
            if arr[i] == 0 && mp[arr[i] * 2] == 1{
                continue
            }
            return true
        }
    }
    return false
}
