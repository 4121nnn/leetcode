class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int x = 0, n = nums.length, max = (1 << maximumBit) - 1;

        for(int i : nums) x ^= i;

        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = x ^ max;
            x ^= nums[n-i-1];
        }
        return a;
    }
}
