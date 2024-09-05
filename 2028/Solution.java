class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int dif = (n + rolls.length) * mean;
        for(int i : rolls) dif -= i;

        if(dif > n * 6 || dif < n) return new int[0];

        int[] res = new int[n];
        int x = dif / n;
        Arrays.fill(res, x);
        
        for(int i = 0; i < dif % n; i++){
            res[i]++;
        }
        return res;
    }
}
// time O(n)
// space O(1)
