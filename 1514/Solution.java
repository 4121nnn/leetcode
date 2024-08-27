class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] max = new double[n];
        max[start_node] = 1.0;
        for(int i = 0; i < n - 1; i++){
            boolean updated = false;
            for(int j = 0; j < edges.length; j++){
                int u = edges[j][0];
                int v = edges[j][1];
                double prob = succProb[j];

                if(max[u] * prob > max[v]){
                    max[v] = max[u] * prob;
                    updated = true;
                }
                if(max[v] * prob > max[u]){
                    max[u] = max[v] * prob;
                    updated = true;
                }
            }    
            if(!updated) break;
        }    
        return max[end_node];
    }
}
// time O(n * E)
// space O(n)
