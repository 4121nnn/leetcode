class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for(int i : chalk) sum += i;

        sum = k % sum;
        int i = 0;
        while(sum > 0){
            sum -= chalk[i];
            if(sum < 0) return i;
            i++;
        }
        return i;
    }
}
// time O(n)
// space (1)
