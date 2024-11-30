class Solution {
    List<Integer> list;
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, List<Integer>> graph = new HashMap();
        Map<Integer, Integer> nodes = new HashMap();

        for(int[] a : pairs) {
            if(!graph.containsKey(a[0])) graph.put(a[0], new ArrayList());

            graph.get(a[0]).add(a[1]);
            nodes.merge(a[0], 1, Integer::sum);
            nodes.merge(a[1], -1, Integer::sum);
        }

        int start = pairs[0][0];
        for(int key : nodes.keySet()) {
            if(nodes.get(key) == 1) {
                start = key;
                break;
            }
        }

        list = new ArrayList<>();
        dfs(graph, start);
        Collections.reverse(list);

        int[][] res = new int[pairs.length][2];
        for(int i = 1; i < list.size(); i++) {
            res[i-1][0] = list.get(i-1);
            res[i-1][1] = list.get(i);
        }
        
        return res;
    }

    void dfs(Map<Integer, List<Integer>> graph, int start) {
        while(graph.containsKey(start) && !graph.get(start).isEmpty()) {
            int v = graph.get(start).remove(0);
            dfs(graph, v);
        }
        list.add(start);
    }
}
