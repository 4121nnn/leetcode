type MaxHeap []int

func (h MaxHeap) Len() int            { return len(h) }
func (h MaxHeap) Less(i, j int) bool  { return h[i] > h[j] }
func (h MaxHeap) Swap(i, j int)       { h[i], h[j] = h[j], h[i] }
func (h *MaxHeap) Push(x interface{}) { *h = append(*h, x.(int)) }
func (h *MaxHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[:n-1]
	return x
}

func pickGifts2(gifts []int, k int) int64 {
    h := &MaxHeap{}
	heap.Init(h)
    for _, i := range gifts {
        heap.Push(h, i)
    }
    for k > 0 {
        k--
        heap.Push(h, int(math.Sqrt(float64(heap.Pop(h).(int)))))
    }
    res := 0
    for _, i := range *h {
        res += i
    }
    return int64(res)

}

func pickGifts(gifts []int, k int) int64 {
    for ; k > 0; k-- {
        i := 0
        for j := range gifts {
            if gifts[i] < gifts[j] {
                i = j
            }
        }
        gifts[i] = int(math.Sqrt(float64(gifts[i])))
    }
    res := 0
    for _, i := range gifts {
        res += i
    }
    return int64(res)

}
