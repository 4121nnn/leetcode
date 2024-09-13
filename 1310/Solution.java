class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1] ^ arr[i];
        }
        int m = queries.length;
        int[] res = new int[m];
        for(int i = 0; i < m; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            if(start == 0){
                res[i] = prefix[end];
            }else{
                res[i] = prefix[start-1] ^ prefix[end];
            }
        }
        return res;

    }
}
