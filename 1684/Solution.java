class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] map = new boolean[26];
        for(char c : allowed.toCharArray()) map[c-'a'] = true;
        int count = 0;
        for(String s : words){
            if(isAllowed(s, map)) count++;
        }
        return count;
    }
    private boolean isAllowed(String s, boolean[] map){
        for(int i = 0; i < s.length(); i++){
            if(!map[s.charAt(i)-'a']) return false;
        }
        return true;
    }
}
// time O(n * m);
// space O(1)
