class Solution {   

    private static int[] primes;
        
    public boolean primeSubOperation(int[] nums) {
        if(primes == null) {
            int length = 0;
            for(int i = 2; i <= 1000; i++){
                if(isPrime(i)) length++;
            }
            primes = new int[length];
            
            for(int i = 2, j = 0; i <= 1000; i++){
                if(isPrime(i)) primes[j++] = i;
            }
        }
        

        int prev = 0;
        for(int num : nums){
            if(num <= prev) return false;
            
            int i = bs(primes, num - prev) - 1;
            if(i != -1) num -= primes[i];

            prev = num;
        }
        return true;
    }
    int bs(int[] nums, int target){
        int l = 0;
        int r = nums.length;
        while(l < r) {
            int m = l + (r - l) / 2;
            if(nums[m] >= target) {
                r = m;
            }else {
                l = m + 1;
            }
        }
        return l;
    }
    boolean isPrime(int x){
        if(x < 2) return false;
        for(int i = 2; i * i <= x; i++) {
            if(x % i == 0) return false;
        }
        return true;
    }
}
