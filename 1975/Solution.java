class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int neg = 0, mn = Integer.MAX_VALUE;
        for(int[] r : matrix){
            for(int i : r) {
                if( i < 0) {
                    i *= -1;
                    neg ^= 1;
                }
                sum += i;
                mn = Math.min(mn, i);
            }
        }
        return sum - 2 * neg * mn;
    }
}
