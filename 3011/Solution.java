class Solution {
    public boolean canSortArray(int[] nums) {
        int min = nums[0], max = nums[0], prevMax = Integer.MIN_VALUE;
        int bits = Integer.bitCount(nums[0]);
        
        for(int i : nums){
            if(Integer.bitCount(i) ==  bits){
                min = Math.min(min, i);
                max = Math.max(max, i);
                
            }else{
                if(prevMax > min) return false;
                prevMax = max;
                min = i;
                max = i;
                bits = Integer.bitCount(i);
                   
            }
        }
        return prevMax < min;
    }
}
