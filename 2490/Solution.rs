impl Solution {
    pub fn is_circular_sentence(s: String) -> bool {
        let chars: Vec<char> = s.chars().collect();
        let n = chars.len();

        if chars[0] != chars[n-1] {
            return false;
        }

        for i in 1..n-1{
            if chars[i] == ' ' && chars[i-1] != chars[i+1] {
                return false;
            }
        }

        true
    }
}
