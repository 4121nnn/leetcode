class Solution {
    public long pickGifts2(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int i: gifts) pq.add(i);
        while(k-- > 0) pq.add((int) Math.sqrt(pq.poll()));
        long res = 0;
        while(!pq.isEmpty())res += pq.poll();
        return res;
    }
}
