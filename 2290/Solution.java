class Solution {
    public int minimumObstacles(int[][] grid) {
        Deque<int[]> q = new ArrayDeque<>();
        int R = grid.length, C = grid[0].length;
        q.offer(new int[]{0, 0, 0});
        boolean[][] v = new boolean[R][C];
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        v[0][0] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] == R -1 && cur[1] == C -1) return cur[2];
            for(int[] d : dir){
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                if(x >= 0 && y >= 0 && x < R && y < C && !v[x][y]){
                    v[x][y] = true;
                    if(grid[x][y] == 1) {
                        q.offerLast(new int[]{x, y, cur[2] + 1});
                    }else{
                        q.offerFirst(new int[]{x, y, cur[2]});
                    }
                }
            }
        }   
        return -1;
    }
}
