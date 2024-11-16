impl Solution {
    pub fn results_array(nums: Vec<i32>, k: i32) -> Vec<i32> {
        let n = nums.len();
        let k = k as usize;
        let mut a = vec![0; n];
        for i in 1..n {
            a[i] = a[i-1];
            if nums[i] - 1 != nums[i-1] {
                a[i] += 1;
            }
        }
        let mut res = vec![-1; n - k + 1];
        for i in 0..res.len() {
            if a[i] == a[i + k - 1] {
                res[i] = nums[i + k - 1];
            }
        }
        res
    }
}
