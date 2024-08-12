import "container/heap"

type minHeap [] int
func (h minHeap) Less (i, j int) bool { return h[i] < h[j] }
func (h minHeap) Swap (i, j int) { h[i], h[j] = h[j], h[i] }
func (h minHeap) Len() int { return len(h) }
func (h *minHeap) Push (x interface{}) { *h = append(*h, x.(int)) }
func (h *minHeap) Pop() interface{} { 
    x := (*h)[len(*h) - 1]
    *h = (*h)[:len(*h) - 1]
    return x
}


type KthLargest struct {
    h *minHeap
    k int
}


func Constructor(k int, nums []int) KthLargest {
    var ins KthLargest
    if len(nums) < k {
        ins = KthLargest{h: (*minHeap)(&nums), k: k}
        heap.Init(ins.h)
    }else{
        kNums := nums[:k]
        ins = KthLargest{h: (*minHeap)(&kNums), k: k}
        heap.Init(ins.h)
        for i := k; i < len(nums); i++ {
            ins.Add(nums[i])
        }
    }
    return ins
}


func (this *KthLargest) Add(val int) int {
    if this.h.Len() < this.k {
        heap.Push(this.h, val)
    }else if val > (*this.h)[0] {
        (*this.h)[0] = val
        heap.Fix(this.h, 0)
    }
    return (*this.h)[0]
}


/**
 * Your KthLargest object will be instantiated and called as such:
 * obj := Constructor(k, nums);
 * param_1 := obj.Add(val);
 */
