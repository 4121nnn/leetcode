/**
 * @param {number} n
 * @return {number}
 */
var nthUglyNumber = function(n) {
    let res = [1];
    let n2 = 0, n3 = 0, n5 = 0;

    while(res.length < n){
        res.push(Math.min(res[n2]*2, Math.min(res[n3]*3, res[n5]*5)));
        if(res[res.length-1] === res[n2]*2) n2++;
        if(res[res.length-1] === res[n3]*3) n3++;
        if(res[res.length-1] === res[n5]*5) n5++;
    }
    return res[n-1];
};
