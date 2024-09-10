class Solution {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int max = 0;
        for(int i = 0; i< n; i++){
            int neg = 0, firstNeg = -1, lastNeg = -1, j = i;
            while(i < n && nums[i] != 0){
                if(nums[i] < 0){
                    neg++;
                    if(firstNeg == -1){
                        firstNeg = i;
                    }else{
                        lastNeg = i;
                    }
                } 
                i++;
            }
            if(neg % 2 == 0){
                max = Math.max(max, i - j);
            }else{
                int maxLeft = Math.max(firstNeg, lastNeg) - j;
                int maxRight = i - firstNeg - 1;
                max = Math.max(max, Math.max(maxLeft, maxRight)); 
            }
        }
        return max;

    }
}
