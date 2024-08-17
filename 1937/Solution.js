/**
 * @param {number[][]} points
 * @return {number}
 */
var maxPoints = function(points) {
    let n = points[0].length
    let cur = new Array(n).fill(0);
    let prev = new Array(n).fill(0);
    let max = 0;

    for(const row of points){
        max = 0
        for(let j = 0; j < n; j++){
            max = Math.max(max - 1, prev[j])
            cur[j] = max;
        }
        max = 0
        for(let j = n - 1; j >= 0; j--){
            max = Math.max(max - 1, prev[j])
            cur[j] = Math.max(cur[j], max) + row[j]
        }
        prev = cur
    }
    max = 0
    for(let i = 0; i < n; i++){
        max = Math.max(max, prev[i])
    }
    return max
};
