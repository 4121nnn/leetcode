class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        int[][] a = new int[n][2];

        for(int i = 0; i < n; i++){
            a[i][0] = nums[i];
            a[i][1] = i;
        }
        Arrays.sort(a, (c, b) -> c[0] == b[0] ? c[1] - b[1] : c[0] - b[0]);
        long res = 0;
        for(int[] r : a){
            int i = r[1];
            if(nums[i] == -1) continue;
            res += nums[i];
            nums[i] = -1;
            if(i >0) nums[i-1] = -1;
            if(i < n - 1) nums[i+1] = -1;
        }
        return res;
    }
}
