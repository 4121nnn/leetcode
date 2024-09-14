class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0, cur = 0, res = 0;
        for(int i : nums) max = Math.max(max, i);
        for(int i : nums){
            if(max == i){
                cur++;
                res = Math.max(res, cur);
            }else{
                cur = 0;
            }
        }
        return res;
    }
}
