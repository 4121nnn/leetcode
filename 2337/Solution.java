class Solution {
    public boolean canChange(String s, String t) {
        int l = 0, r = 0;
        for(int i = 0; i < s.length(); i++){
            char ss = s.charAt(i);
            char tt = t.charAt(i);
            if(ss == 'R'){
                if(l > 0) return false;
                r++;
            }else if(ss == 'L') l--;

            if(tt == 'L'){
                if(r > 0) return false;
                l++;
            }else if(tt == 'R') r--;
            
            if(l < 0 || r < 0) return false;
        }
        return l == 0 && r == 0;
    }
}
