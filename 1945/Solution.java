class Solution {
    public int getLucky(String s, int k) {
        int sum = 0;
        for(char c : s.toCharArray()) sum += sumDigits(c - 96);
        while(k-- > 1) sum = sumDigits(sum);
        return sum;
    }

    int sumDigits(int x){
        int sum = 0;
        while(x > 0){
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
// time O(k + n)
// space O(1)
