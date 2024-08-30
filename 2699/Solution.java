class Solution {
    Map<Integer, Map<Integer, Integer>> g;
    int n;
    int MAX = 2_000_000_000;
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        this.n = n;
        g = new HashMap<>();
        for(int[] e : edges){
            if(e[2] != -1){
                g.computeIfAbsent(e[0], k -> new HashMap()).put(e[1], e[2]);
                g.computeIfAbsent(e[1], k -> new HashMap()).put(e[0], e[2]);
            }   
        }
        int curDist = dijkstra(source, destination);

        if(curDist < target) return new int[0][0];

        for(int[] e : edges){
            if(e[2] == -1){
                if(curDist == target) { 
                    e[2] = MAX;
                    continue;
                }
                e[2] = 1;
                g.computeIfAbsent(e[0], k -> new HashMap()).put(e[1], 1);
                g.computeIfAbsent(e[1], k -> new HashMap()).put(e[0], 1);
                curDist = dijkstra(source, destination);
                if(curDist <= target){
                    e[2] += target - curDist;
                    curDist = target;
                }
            }   
        }

        return curDist == target ? edges : new int[0][0];
    }
    int dijkstra(int source, int destination){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{source, 0});
        boolean[] visited = new boolean[n];

        while(!pq.isEmpty()){
            int[] curNode = pq.poll();
            int curEdge = curNode[0];
            int dist = curNode[1];

            if(curEdge == destination) return dist;

            if(visited[curEdge]) continue;

            visited[curEdge] = true;

            Map<Integer, Integer> neigh = g.getOrDefault(curEdge, new HashMap<>());

            for(Map.Entry<Integer, Integer> entry : neigh.entrySet()){
                int nextNode = entry.getKey();
                int weight = entry.getValue();
                if(!visited[nextNode]){
                    pq.add(new int[]{nextNode, weight + dist});
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
