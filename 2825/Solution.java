class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        for(int i = 0, j = 0; i < str1.length(); i++){
            char c = str1.charAt(i);
            char x = (char) (c + 1);
            if(x == 123) x = 'a';
            if(str2.charAt(j) == c || str2.charAt(j) == x) {
                j++;
                if(j == str2.length()) return true;
            } 
        }
        return false;
    }
}
