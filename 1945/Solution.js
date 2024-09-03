/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var getLucky = function(s, k) {
    const sumDigits = (x) => {
        let sum = 0;
        while(x > 0){
            sum += x % 10;
            x = Math.floor(x / 10);
        }
        return sum;
    }
    let sum = 0;
    for (let c of s) {
        sum += sumDigits(c.charCodeAt(0) - 96);
    }

    while(k-- > 1){
        sum = sumDigits(sum);
    }

    return sum;
};
