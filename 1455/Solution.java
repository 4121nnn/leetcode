class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int i = 0;
        for(String s : sentence.split(" ")) {
            i++;
            if(s.startsWith(searchWord)) return i;
        }
        return -1;
    }
}
