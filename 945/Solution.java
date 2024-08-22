class Solution {
    public int minIncrementForUnique(int[] nums) {
        int max = 0;
        for(int i : nums) if(i > max) max = i;
        int[] a = new int[max + 1];
        for(int i : nums) a[i]++;

        int res = 0;
        for(int i = 0; i < a.length-1; i++){
            if(a[i] > 1){
                res += a[i] -1;
                a[i + 1] += a[i] -1; 
            }
        }
        while(a[max] > 1) {
            a[max]--;
            res += a[max];
        }

        return res;
    }
}
// time O(n)
// space O(max)
