class Solution {
    public long getDescentPeriods(int[] prices) {
        long res = 1;
        long cur = 1;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] == prices[i-1]-1){
                cur++;
            }else{
                cur = 1;
            }
            res += cur;
        } 
        return res;
    }
}

// time O(n)
// space O(1)
