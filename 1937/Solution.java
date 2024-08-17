class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[] cur = new long[n];
        long[] prev = new long[n];
        long max = 0;
        for(int[] row : points){
            max = 0;
            for(int j = 0; j < n ; j++){
                max = Math.max(max - 1, prev[j]);
                cur[j] = max;
            }
            max = 0;
            for(int j = n-1; j >=0 ; j--){
                max = Math.max(max - 1, prev[j]);
                cur[j] = Math.max(cur[j], max) + row[j];
            }
            prev = cur;
        }
     
        max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, prev[i]);
        }
        return max;
    }
}
// time O(m*n)
// space O(n)
