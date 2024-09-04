class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m * n != original.length) return new int[0][0];
        int[][] res = new int[m][];
        for(int i = 0; i < m ; i++){
            res[i] = Arrays.copyOfRange(original, i * n, (i+1) * n);  
        }
        return res;
    }
}
// time O(m * n);
// space O(1)
