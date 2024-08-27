/**
 * @param {number} n
 * @param {number[][]} edges
 * @param {number[]} succProb
 * @param {number} start_node
 * @param {number} end_node
 * @return {number}
 */
var maxProbability = function(n, edges, succProb, start_node, end_node) {
    let max = new Array(n).fill(0.0);
    max[start_node] = 1.0;

    for(let i = 0; i < n - 1; i++){
        let updated = false;
        for(let j = 0; j < edges.length; j++){
            let u = edges[j][0];
            let v = edges[j][1];
            let prob = succProb[j];
            if(max[u] * prob > max[v]){
                max[v] = max[u] * prob;
                updated = true;
            }
            if(max[v] * prob > max[u]){
                max[u] = max[v] * prob;
                updated = true;
            }
        }
        if(!updated){
            break;
        }
    }
    return max[end_node];
};
