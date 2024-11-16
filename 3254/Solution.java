class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] a = new int[n];
        for(int i = 1; i < n; i++){
            a[i] = a[i-1];
            if(nums[i-1] != nums[i] - 1) a[i]++;
        }
        
        int[] res = new int[n - k + 1];

        for(int i = 0; i< res.length; i++){
            if(a[i] == a[i+k-1]){
                res[i] = nums[i+k-1];
            }else{
                res[i] = -1;
            }
        }
        return res;
    }
}
