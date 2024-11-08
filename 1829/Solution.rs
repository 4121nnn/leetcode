impl Solution {
    pub fn get_maximum_xor(nums: Vec<i32>, maximum_bit: i32) -> Vec<i32> {
        let mut x = 0;
        let n = nums.len();
        let max = (1 << maximum_bit) -1;
        for i in 0..n {
            x ^= nums[i];
        }
        let mut a = vec![0; n];
        
        for i in 0..n {
            a[i] = x ^ max;
            x = x ^ nums[n - i - 1];
        }
        a
    }
}
