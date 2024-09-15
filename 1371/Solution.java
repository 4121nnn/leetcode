class Solution {
    public int findTheLongestSubstring(String s) {
        int mask = 0, res = 0;
        
        int[] hm = new int[32];
        Arrays.fill(hm, -2);
        hm[0] = -1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            switch(c){
                case 'a' -> mask ^= 1;
                case 'e' -> mask ^= 2;
                case 'i' -> mask ^= 4;
                case 'o' -> mask ^= 8;
                case 'u' -> mask ^= 16;
            }
            if(hm[mask] != -2){
                res = Math.max(res, i - hm[mask]);
            }else{
                hm[mask] = i;
            }
        }
        return res;

    }
}
