class Solution {
    public int minBitFlips(int start, int goal) {
        int count = 0;
        int dif = start ^ goal;
        while(dif > 0){
            count += dif & 1;
            dif >>= 1;
        }
        return count;
    }
}

