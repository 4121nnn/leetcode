func smallestDistancePair(nums []int, k int) int {
    sort.Ints(nums)
    low, high := 0, nums[len(nums) - 1] - nums[0]
    for low <= high {
        mid := (high - low) / 2 + low
        if count(nums, mid) < k { 
            low = mid + 1
        } else { 
            high = mid - 1
        }
    }

    return low
}

func count(nums []int, max int) int{
    count, j := 0, 0
    for i := 0; i < len(nums); i++{
        for j < len(nums) && nums[j] - nums[i] <= max { 
            j++ 
        }
        count += j - i - 1
    }
    return count
}
