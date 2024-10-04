class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long res = 0;
        int n = skill.length;
        int team = skill[0] + skill[n - 1];
        for(int i = 0; i < n / 2; i++){
            if(skill[i] + skill[n - i - 1] != team) return -1;
            res += (skill[i] * skill[n - i - 1]);
        }
        return res;
    }
}
