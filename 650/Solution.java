class Solution {
    int res = 0;
    public int minSteps(int n) {
        if(n == 1 ) return res;
        int x = n / 2;
        while(n % x != 0) x--;
        res += n / x;
        return minSteps(x);
    }
}

// time O(n) - O(log n)
// space O(1)
