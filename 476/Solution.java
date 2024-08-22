class Solution {
    public int findComplement(int num) {
        int x = 0, temp = num;
        while(temp != 0){
            temp = temp >> 1;
            x++;
        }
        return num ^ (int) (Math.pow(2, x) - 1);
    }
}
// time O(1)
// space O(1)
