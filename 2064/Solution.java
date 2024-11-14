class Solution {
    public int minimizedMaximum(int n, int[] nums) {
        int l = 1;
        int r = 0;
        int res = 0;
        for(int i : nums) r = Math.max(r, i);
        res = r;
        while(l <= r){
            int m = l + (r - l) / 2;
            if(canDistribute(m, n, nums)){
                res = m;
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return res;
    }
    boolean canDistribute(int k, int n, int[] nums){
        int count = 0;
        for(int i: nums){
            count += i / k + (i % k == 0 ? 0 : 1);
        }
        return count <= n;
    }
}
