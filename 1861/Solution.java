class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int ROW = box.length, COL = box[0].length;
        char[][] res = new char[COL][ROW];
        for(char[] a : res) Arrays.fill(a, '.');

        for(int r = 0; r < ROW; r++) {
            int last = COL - 1;
            for(int c = COL - 1; c >= 0; c--) {
                if(box[r][c] == '#'){
                    res[last--][ROW - r - 1] = '#';
                }else if(box[r][c] == '*'){
                    last = c - 1;
                    res[c][ROW - r - 1] = '*';
                }
            }
        }
        return res;
    }
}
