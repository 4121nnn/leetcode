class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        boolean[] a = new boolean[10001];
        for(int i : banned) a[i] = true;
        int sum = 0, count = 0;
        for(int i = 1; i <= n; i++){
            if(a[i]) continue;
            sum += i;
            if(sum > maxSum) return count;
            count++;
        }
        return count;
    }
}
