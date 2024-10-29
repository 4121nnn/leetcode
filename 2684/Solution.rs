impl Solution {
    pub fn max_moves(grid: Vec<Vec<i32>>) -> i32 {
        let n = grid.len();
        let m = grid[0].len();
        let mut dp = vec![0; n];
        for i in 0..n {
            dp[i] = grid[i][0];
        }

        for j in 1..m {
            let mut moved = false;
            let mut next = dp.clone(); 
            for i in 0..n {
                if dp[i] < grid[i][j] ||
                   (i > 0 && dp[i-1] < grid[i][j]) ||
                   (i < n-1 && dp[i+1] < grid[i][j]) {
                    moved = true;
                    next[i] = grid[i][j];
                } else {
                    next[i] = i32::MAX;
                }
            }
            if !moved {
                return j as i32 - 1;
            }
            dp = next;
        }

        return m as i32 - 1;
    }
}
