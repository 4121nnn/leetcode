class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0, high = nums[nums.length -1] - nums[0];
        while(low <= high){
            int mid = (high + low) / 2;
            if(count(nums, mid) < k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
    private int count(int[] nums, int max){
        int count = 0, j = 0;
        for(int i = 0; i < nums.length; i++){
            while(j < nums.length && nums[j] - nums[i] <= max) j++;
            count += j - i - 1;
        }
        return count;
    }
}
