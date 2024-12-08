class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int res = 0, n = events.length;
        int[] a = new int[n + 1];

        for(int i = n -1; i >= 0; i--) a[i] = Math.max(a[i+1], events[i][2]);
        
        for(int i = 0; i < n; i++) {
            int j = bs(events, events[i][1]);
            res = Math.max(res, a[j] + events[i][2]);
        }
        return res;
    } 
    private int bs(int[][] events, int t){
        int l = 0, r = events.length -1;
        while(l <= r){
            int m = l + (r - l) / 2;
            if(events[m][0] > t){
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return l;
    }
}
