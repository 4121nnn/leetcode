/**
 * @param {string} n
 * @return {string}
 */
var nearestPalindromic = function(n) {
    let num = BigInt(n);
    if(num <= 10n) return (num - 1n).toString();
    if(num === 11n) return "9";
    let length = n.length;

    let leftHalf = BigInt(n.slice(0, (length + 1) / 2));
    
    let candidates = [
        genPalFromLeftHalf(leftHalf, length % 2 == 0),
        genPalFromLeftHalf(leftHalf - 1n, length % 2 == 0),
        genPalFromLeftHalf(leftHalf + 1n, length % 2 == 0),
        BigInt(10n ** BigInt(length - 1)) - 1n,
        BigInt(10n ** BigInt(length)) + 1n,
    ]

  

    let minDif =BigInt(Number.MAX_SAFE_INTEGER);
    let res = 0n;

    for(let candidate of candidates){
        if(candidate === num) continue;
        let dif = candidate > num ? candidate - num : num - candidate;
        if(dif < minDif || (dif === minDif && candidate < res)){
            res = candidate;
            minDif = dif;
        }
    }
    return res.toString();
};

function genPalFromLeftHalf(leftHalf, even){
    let res = leftHalf;
    if(!even) leftHalf = leftHalf / 10n;
    while(leftHalf > 0n){
        res = res * 10n + leftHalf % 10n;
        leftHalf /= 10n;
    }
    return res;
}
