/**
 * @param {number} n
 * @return {number}
 */
var minSteps = function(n) {
    let d = 2
    let sum = 0
    while( n > 1 ){
        if(n % d == 0){
            sum += d;
            n /= d
        }else{
            d++
        }
    }
    return sum
};
