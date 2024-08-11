class Solution {
    public int minimumChairs(String s) {
        int res = 0;
        int max = 0;
        for(char c : s.toCharArray()){
            res += c == 'E' ? 1 : -1;
            max = Math.max(max, res);
        }
        return max;
    }
}
