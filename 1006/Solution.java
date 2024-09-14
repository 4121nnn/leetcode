class Solution {
    public int clumsy(int n) {
        int res = n--;
        if(n > 0) res *= n--;
        if(n > 0) res /= n--;
        if(n > 0) res += n--;
        while(n > 0){
            int cur = n--;
            if(n > 0) cur *= n--;
            if(n > 0) cur /= n--;
            res -= cur;
            if(n > 0) res += n--;
        }
        return res;
    }
}
