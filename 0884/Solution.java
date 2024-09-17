class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] a1 = s1.split(" ");
        String[] a2 = s2.split(" ");
        Map<String, Integer> hm = new HashMap<>();
        for(String s : a1) hm.merge(s, 1, Integer::sum);
        for(String s : a2) hm.merge(s, 1, Integer::sum);
        List<String> res = new ArrayList<>();
        for(Map.Entry<String, Integer> e : hm.entrySet()){
            if(e.getValue() == 1) res.add(e.getKey());
        }
        return res.toArray(new String[0]);
    }
}
