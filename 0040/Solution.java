class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);
        return res;
    }
    private void backtrack(int[] cand, int t, int i){
        if(t == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int j = i; j < cand.length; j++){
            if(j > i && cand[j] == cand[j-1]) continue;
            if(cand[i] > t) break;
            temp.add(cand[j]);
            backtrack(cand, t - cand[j], j+1);
            temp.removeLast();
        }
       
    }
}
// time O(n * 2^n)
// space O(target)
