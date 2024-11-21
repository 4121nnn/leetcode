class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] a = new int[m][n];

        for(int[] g : guards) a[g[0]][g[1]] = 1;
        for(int[] w : walls) a[w[0]][w[1]] = 1;

        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = m * n - guards.length - walls.length;
        for(int[] g : guards){
            for(int[] d : dir){
                int x = g[0] + d[0];
                int y = g[1] + d[1];
                while(x >= 0 && x < m && y >= 0 && y < n){
                    if(a[x][y] == 1) break;
                    if(a[x][y] == 0){
                        a[x][y] = 2;
                        res--;
                    }
                    x += d[0];
                    y += d[1];
                }
            }
        }
        return res;
    }
}
