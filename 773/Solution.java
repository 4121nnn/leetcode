class Solution {
    public int slidingPuzzle(int[][] board) {
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        String s = "";
        String target = "123450";
        int[][] dir = {{1,3}, {0,2,4}, {1,5}, {0,4}, {1,3,5}, {2,4}};
        for(int[] a : board) for(int i : a) s += i;
        set.add(s);
        q.add(s);
        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String cur = q.poll();
                if(cur.equals(target)) return step;
                int index = cur.indexOf('0');
                for(int move: dir[index]){
                    StringBuilder next = new StringBuilder(cur);
                    next.setCharAt(index, next.charAt(move));
                    next.setCharAt(move, '0');

                    if(!set.contains(next.toString())){
                        set.add(next.toString());
                        q.offer(next.toString());
                    }
                }
            }   
            step++;
        }
        return -1;

    }
}
