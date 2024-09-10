class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return find(nums, upper) - find(nums, lower-1);
    }
    
    long find(int[] nums, int upper){
        long res = 0;
        int i = 0, j = nums.length-1;
        while(i < j){
            while(i < j && nums[i] + nums[j] > upper)
                j--;
                
            res += j - i;
            i++;
        }
        return res;
    }
}
