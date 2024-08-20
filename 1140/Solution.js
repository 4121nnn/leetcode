/**
 * @param {number[]} piles
 * @return {number}
 */
var stoneGameII = function(piles) {
    const n = piles.length;
    const sufSum = new Array(n + 1).fill(0);
    for(let i = n - 1; i >= 0; i--){
        sufSum[i] = sufSum[i+1] + piles[i]; 
    }
    const memo = Array.from({ length : n}, () => new Array(n + 1).fill(0));

    const maxStonesAliceCanGet = (m, i) => {
        if(i >= n) return 0;
        if(i + 2 * m >= n) return sufSum[i];
        if(memo[i][m] !== 0) return memo[i][m];

        let maxStones = 0;
        for(let x = 1; x <= 2 * m; x++){
            const curStones = sufSum[i]  - maxStonesAliceCanGet(Math.max(x, m), i + x);
            maxStones = Math.max(maxStones, curStones);
        }
        return memo[i][m] = maxStones;
    };
    return maxStonesAliceCanGet(1, 0);
};
