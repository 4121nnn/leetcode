class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] a = new int[n];
        for(int[] r : edges){
            a[r[1]]++;
        }
        int res = -1;
        for (int i = 0; i < n; i++){
            if(a[i] == 0){
                if(res != -1) return -1;
                res = i;
            }
        }
        return res;
    }
}
