class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int ind =-1, min = Integer.MAX_VALUE;
        for(int i = 0; i < points.length; i++){
            if(points[i][0] == x || points[i][1] == y){
                int cur = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                if(cur < min){
                    min = cur;
                    ind = i;
                }
            }
        }
        return ind;
    }
}
