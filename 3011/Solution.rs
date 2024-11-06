impl Solution {
    pub fn can_sort_array(nums: Vec<i32>) -> bool {
        fn bit_count(mut num: i32) -> i32 {
            let mut count = 0;
            while num > 0 {
                count += num & 1;
                num >>= 1;
            }
            count
        }

        let (mut min, mut max, mut bits, mut prev_max) = (nums[0], nums[0], bit_count(nums[0]), 0);

        for i in 0..nums.len() {
            if bit_count(nums[i]) == bits {
                min = min.min(nums[i]);
                max = max.max(nums[i]);
            } else {
                if prev_max > min {
                    return false;
                }
                prev_max = max;
                max = nums[i];
                min = nums[i];
                bits = bit_count(nums[i]);
            }
        }
        prev_max < min

    }
}
