impl Solution {
    pub fn min_changes(s: String) -> i32 {
        let mut count = 0;
        let mut c = s.chars();
        while let (Some(x), Some(y)) = (c.next(), c.next()) {
            if x != y {
                count += 1;
            }
        }
        count
    }
}
