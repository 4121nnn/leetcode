func combinationSum2(nums []int, target int) [][]int {
    var res [][]int
    var temp []int
    sort.Ints(nums)
    backtrack(nums, target, 0, temp, &res)
    return res
}

func backtrack(nums []int, target int, ind int, temp []int, res *[][]int){
    if target == 0 {
        valid := make([]int, len(temp))
        copy(valid, temp)
        *res = append(*res, valid)
        return
    }
    for i:=ind; i < len(nums); i++{
        if i > ind && nums[i] == nums[i-1] { continue }
        if nums[i] > target { break }
        temp = append(temp, nums[i])
        backtrack(nums, target - nums[i], i + 1, temp, res)
        temp = temp[:len(temp) -1]
    }
}
