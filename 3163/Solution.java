class Solution {
    public String compressedString(String s) {
        StringBuilder sb = new StringBuilder();

        int i = 0, n = s.length();

        while(i < n){
            char cur = s.charAt(i);
            int count = 1;
            i++;
            while(i < n && count < 9 && cur == s.charAt(i)){
                count++;
                i++;
            }
            
            sb.append(count);
            sb.append(cur);
        }

        return sb.toString();
    }
}
