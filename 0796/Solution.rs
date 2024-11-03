impl Solution {
    pub fn rotate_string(s: String, goal: String) -> bool {
        if s.len() != goal.len() {
            return false;
        }

        let n = s.len();

        let a: Vec<char> = s.chars().collect();
        let b: Vec<char> = goal.chars().collect();

        for i in 0..n {
            if a[i] == b[0] {
                if a[i..] == b[..(n-i)] && a[..i] == b[(n-i)..]{
                    return true;
                }
            }
        }
        false
    }
}
