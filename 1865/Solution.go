type FindSumPairs struct {
    nums1 []int
    nums2 []int
    hm map[int]int
}


func Constructor(nums1 []int, nums2 []int) FindSumPairs {
    hm := make(map[int]int)
    for _, i := range nums2{
        hm[i]++
    }
    return FindSumPairs{nums1: nums1, nums2: nums2, hm: hm,}
}


func (this *FindSumPairs) Add(index int, val int)  {
    this.hm[this.nums2[index]]--
    this.nums2[index] += val
    this.hm[this.nums2[index]]++
}


func (this *FindSumPairs) Count(tot int) int {
    res := 0
    for _, i := range this.nums1{
        res += this.hm[tot - i]
    }
    return res
}


/**
 * Your FindSumPairs object will be instantiated and called as such:
 * obj := Constructor(nums1, nums2);
 * obj.Add(index,val);
 * param_2 := obj.Count(tot);
 */
