class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        int max = 0;
        for(int i : nums) max = Math.max(max, i);
        int[] m = new int[max+1];

        long res = 0;
        long sum = 0;
        int dup = 0;

        for(int i =0; i < k-1; i++){
            sum+=nums[i];
            if(m[nums[i]] >= 1){
                dup++;
            }
            m[nums[i]]++;
        }
        int prev = 0;

        for(int i = k-1; i < nums.length; i++){
            sum += nums[i] - prev;
            if(m[nums[i]] >=1) dup++;

            m[nums[i]]++;

            if(dup == 0) res = Math.max(res, sum);

            prev = nums[i - k + 1];
            if(m[prev] > 1){
                dup--;
            }
            m[prev]--;
        }

        return res;
    }
}
