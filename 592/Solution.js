/**
 * @param {string} expression
 * @return {string}
 */
var fractionAddition = function(s) {
    let num = 0;
    let den = 1;
    let i = 0;
    while(i < s.length){
        let sign = 1;
        if(s[i] === '-'){
            sign = -1;
            i++;
        }else if(s[i] === '+'){
            i++;
        }

        let j = i;
        while(j < s.length && isDigit(s[j])){
            j++;
        }
        let curNum = sign * parseInt(s.substring(i, j));
        j++;

        i = j;
        while(j < s.length && isDigit(s[j])){
            j++;
        }
        let curDen = parseInt(s.substring(i, j));

        num = num * curDen + den *curNum;
        den *= curDen;

        i = j;

        let gcdValue = gcd(Math.abs(num), den);
        num /= gcdValue;
        den /= gcdValue;
    }

   

    return `${num}/${den}`;
};
function isDigit(char){
    return char >= '0' && char <= '9';
}

function gcd(a, b){
    while(b != 0){
        let temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}
