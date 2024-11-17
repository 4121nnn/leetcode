class Solution {
    public int shortestSubarray(int[] nums, int k) {
        long sum = 0;
        int res = Integer.MAX_VALUE;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> (int) (a[0] - b[0]));
        
        for(int r = 0; r < nums.length; r++){
            sum += nums[r];
            if(sum >= k) res = Math.min(res, r + 1);

            while(!pq.isEmpty() && sum - pq.peek()[0] >= k)
                res = Math.min(res, r - (int)pq.poll()[1]);
                
            pq.add(new long[]{sum, r});
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
