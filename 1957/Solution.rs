impl Solution {
    pub fn make_fancy_string(s: String) -> String {
        let mut res = String::new();
        let mut prev = '\0';
        let mut freq = 0;
        for c in s.chars() {
            if c == prev {
                freq += 1;
            } else {
                freq = 1;
                prev = c;
            }
            if freq < 3 {
                res.push(c);
            }
        }
        res
    }
}
