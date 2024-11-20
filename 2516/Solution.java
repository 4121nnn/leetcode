class Solution {
    public int takeCharacters(String s, int k) {
        int[] a = new int[3];
        for(char c :  s.toCharArray()) a[c - 'a']++;

        if(a[0] < k || a[1] < k || a[2] < k) return -1;

        int res = Integer.MAX_VALUE;
        for(int l = 0, r = 0; r < s.length(); r++){
            a[s.charAt(r) - 'a']--;

            while(l < s.length() && a[0] < k || a[1] < k || a[2] < k) {
                a[s.charAt(l++) - 'a']++;
            }

            res = Math.min(res, s.length() - (r - l + 1));
        }
        return res;
    }
}
