class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> hm = new HashMap<>();
        for(int[] r : matrix) {
            StringBuilder sb = new StringBuilder();
            if(r[0]==1){
                for(int i : r){
                    sb.append( i == 0 ? 1 : 0); 
                }
            }else{
                for(int i : r) sb.append(i);
            }
            hm.merge(sb.toString(), 1, Integer::sum);
        }

        return Collections.max(hm.values());

    }
}
