class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        char prev = s.charAt(0);
        int freq = 0;
        for(char c : s.toCharArray()){
            if(prev == c){
                freq++;
            }else{
                freq = 1;
                prev = c;
            }
            if(freq < 3){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
