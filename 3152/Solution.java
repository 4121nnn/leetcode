class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] a = new int[nums.length];
        for(int i = 1; i < nums.length; i++) {
            a[i] = a[i-1];
            if((nums[i] & 1) == (nums[i-1] & 1)) a[i]++;
        }
        boolean[] res = new boolean[queries.length];
        for(int i = 0; i < queries.length; i++){
            if(a[queries[i][0]] == a[queries[i][1]]) res[i] = true;
        }
        return res;
    }
}
