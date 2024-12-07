class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1, r = 1_000_000_000;
        while(l <= r){
            int m = (r + l) / 2;
            int count = 0;
            for(int i : nums) count += (i -1)/ m;
            if(count > maxOperations){
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        return l;
    }
}
