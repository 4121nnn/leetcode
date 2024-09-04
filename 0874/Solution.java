class Solution {
    int HASH_MULTIPLIER = 60001;
    public int robotSim(int[] commands, int[][] obstacles) {
        int max = 0;
        int x = 0, y = 0, dir = 0;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Set<Integer> obs = new HashSet<>();

        for(int[] o : obstacles){
           obs.add(hashCoordinates(o[0], o[1]));
        }

        for(int command : commands){
            switch(command){
                case -1 : dir = (dir + 1) % 4; break;
                case -2 : dir = (dir + 3) % 4; break;
                default : {
                    while(command-- > 0){
                        int newX = x + dirs[dir][0];
                        int newY = y + dirs[dir][1];

                        if(obs.contains(hashCoordinates(newX, newY))) break;
                        
                        x = newX; 
                        y = newY;
                    }
                    max = Math.max(max, x * x + y * y);
                }
            }
        }
        return max;
    }

    int hashCoordinates(int x, int y){
        return x + y * HASH_MULTIPLIER;
    }
}
// time O(n + k)
// space O(k)
