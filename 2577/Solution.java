class Solution {
    public int minimumTime(int[][] grid) {
        if(grid[0][1] > 1 && grid[1][0] > 1) return -1;

        int R = grid.length, C = grid[0].length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] v = new boolean[R][C];

        q.add(new int[]{0, 0, 0});
        v[0][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(cur[0] == R - 1 && cur[1] == C - 1) return cur[2];

            for(int[] d : dir){
                int x = cur[0] - d[0];
                int y = cur[1] - d[1];
                if(x >= 0 && y >= 0 && x < R && y < C && !v[x][y]){
                    v[x][y] = true;
                    if(cur[2] + 1 < grid[x][y]){
                        int z = grid[x][y] - cur[2] - 1;
                        if(z % 2 != 0) z++;
                        q.add(new int[]{x, y, cur[2] + z + 1});
                    }else{
                        q.add(new int[]{x, y, cur[2] + 1});
                    }
                }
            }
        }
        
        return -2;
    }
}
