class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).getFirst();
        int max = arrays.get(0).getLast();
        int res = 0;
        for(int i = 1; i < arrays.size(); i++){
            int curMin = arrays.get(i).getFirst();
            int curMax = arrays.get(i).getLast();
            res = Math.max(Math.max(curMax - min, max - curMin), res);
            min = Math.min(min, curMin);
            max = Math.max(max, curMax);
        }
        return res;
    }
}
// time O(n)
// space O(1)
