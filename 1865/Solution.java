class FindSumPairs {
    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> hm;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        hm = new HashMap<>();
        for(int i : nums2) hm.merge(i, 1, Integer::sum);
    }
    
    public void add(int index, int val) {
        hm.merge(nums2[index], -1, Integer::sum);
        nums2[index] += val;
        hm.merge(nums2[index], 1, Integer::sum);
    }
    
    public int count(int tot) {
        int count = 0;
        for(int i : nums1)
            count += hm.getOrDefault(tot - i, 0);
        
        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
