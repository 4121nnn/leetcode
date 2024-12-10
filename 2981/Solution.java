class Solution {
    public int maximumLength(String s) {
        int[][] a = new int[26][3];
        int n = s.length();
        int i = 0;
        while(i < n) {
            char c = s.charAt(i);
            int start = i++;
            while(i < n && c == s.charAt(i)) i++;
            Arrays.sort(a[c - 'a']);
            a[c-'a'][0] = Math.max(a[c-'a'][0], i - start); 
        }
        int res = 0;
        for(int[] r : a){
            Arrays.sort(r);
            int i1 = r[0], i2 = r[1], i3 = r[2];
            if(i1 == i2 && i1 == i3) res = Math.max(res, i1);
            if(i3 == i2 + 1 || i3 == i2) res = Math.max(res, i3 - 1);
            else res = Math.max(res, i3 - 2);
        }
        return res == 0 ? -1 : res;
    }
}
