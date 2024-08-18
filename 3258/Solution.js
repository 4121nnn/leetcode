/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var countKConstraintSubstrings = function(s, k) {
  let res = 0
  let a = 0
  let b = 0
  for(let i = 0; i < s.length; i++){
    a = 0; b = 0
    for(let j = i; j < s.length; j++){
        if(s[j] === '0') a++
        else b++

        if(a > k && b > k) break;
        res++;
    }
  }
  return res;
};
