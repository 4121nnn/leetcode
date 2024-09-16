class Solution {
    public int findMinDifference(List<String> timePoints) {
        int i = 0, n = timePoints.size(), res = Integer.MAX_VALUE;
        int[] min = new int[n];
        for(String s : timePoints){
            int h = Integer.parseInt(s.substring(0, 2));
            int m = Integer.parseInt(s.substring(3));
            min[i++] = h * 60 + m;
        }
        Arrays.sort(min);
        for(i = 1; i < n; i++){
            res = Math.min(res, min[i] - min[i-1]);
        }
        return Math.min(res, 24 * 60 + min[0] -  min[n - 1]);
    }
}
