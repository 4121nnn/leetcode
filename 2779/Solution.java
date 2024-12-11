class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int max = 0;
        for(int i : nums) max = Math.max(max, i);
        int[] arr = new int[max + 2];
        for(int i : nums){
            arr[Math.max(0, i - k)]++;
            arr[Math.min(max+1, i + k + 1)]--;
        }
        int res = 0;
        int count = 0;
        for(int i : arr) {
            count += i;
            res = Math.max(res, count);
        }
        return res;

    }
}
