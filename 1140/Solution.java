class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] sufSum = new int[n + 1];

        for(int i = n - 1; i >= 0; i--)
            sufSum[i] = sufSum[i+1] + piles[i];

        return maxStonesAliceCanGet(sufSum, 1, 0, new int[n][n + 1]);
    }

    private int maxStonesAliceCanGet(int[] sufSum, int m, int i, int[][] memo){
        int n = sufSum.length - 1;

        if(i >= n) return 0;
        if(i + 2 * m >= n) return sufSum[i];
        if(memo[i][m] != 0) return memo[i][m];

        int maxStones = 0;
        for(int x = 1; x <= 2 * m; x++){
            int curStones = sufSum[i] - maxStonesAliceCanGet(sufSum, Math.max(m, x), i + x, memo);
            maxStones = Math.max(maxStones, curStones);
        }
        return memo[i][m] = maxStones;
    }
}

// time O(n^3)
// space O(n * n)
