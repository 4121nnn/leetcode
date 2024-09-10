class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int max = 0;
        for(int i : asteroids) if(max < i) max = i;
        int[] map = new int[max+1];
        for(int i : asteroids) map[i]++;
        long sum = mass;
        for(int i = 0; i <= max; i++){
            if(i > sum) return false;
            if(sum >= 100000) return true;
            sum += i * map[i];
        }
        return true;
    }
}
