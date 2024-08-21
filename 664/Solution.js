/**
 * @param {string} s
 * @return {number}
 */
var strangePrinter = function(s) {
    const nextOccurrence = computeNextOccurrence(s);
    const n = nextOccurrence.length;

    const memo = Array.from({ length: n }, () => Array(n).fill(-1));

    const compute = (start, end) => {
        if (start > end) return 0;
        if (memo[start][end] !== -1) return memo[start][end];

        let minTurns = 1 + compute(start + 1, end);

        let nextPos = nextOccurrence[start]; 

        while (nextPos !== -1 && nextPos <= end) {
            let curMin = compute(start, nextPos - 1) + compute(nextPos + 1, end);
            minTurns = Math.min(minTurns, curMin);
            nextPos = nextOccurrence[nextPos];
        }

        return memo[start][end] = minTurns;
    };

    return compute(0, n - 1);
};


function computeNextOccurrence(s){
    let res = [];
    let i = 0;

    while(i < s.length){
        res.push(s[i]);
        let j = i;
        while( i < s.length && s[i] === s[j]) i++;
        
    }

    let nextOccurrence = new Array(res.length).fill(-1);
    let map = new Array(26).fill(-1);
    for(i = res.length -1; i >= 0; i--){
         let ind = res[i].charCodeAt(0) - 'a'.charCodeAt(0);
        nextOccurrence[i] = map[ind];
        map[ind] = i;
    }
    return nextOccurrence;
}
