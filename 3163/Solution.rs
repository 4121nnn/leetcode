impl Solution {
    pub fn compressed_string(s: String) -> String {
        let mut res = String::with_capacity(s.len() * 2);

        let chars: Vec<char> = s.chars().collect();

        let mut count = 1;
        let mut cur = chars[0];
        let n = chars.len();
        let mut i = 0;
        while i < n {
            cur = chars[i];
            count = 1;
            i += 1;
            while i < n && count < 9 && chars[i] == cur {
                count += 1;
                i += 1;
            }
            res.push((count as u8 + b'0') as char);
            res.push(cur);
           
        }

        res
    }
}
