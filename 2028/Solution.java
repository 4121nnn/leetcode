class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int dif = (n + rolls.length) * mean;
        for(int i : rolls) dif -= i;

        if(dif > n * 6 || dif < n) return new int[0];

        int[] res = new int[n];
        int x = dif / n + 1, r = dif % n;
        for(int i = 0; i < r; i++){
            res[i] = x;
        }
        x--;
        for(int i = r; i < n; i++){
            res[i] = x;
        }
        return res;
    }
}
// time O(n)
// space O(1)
