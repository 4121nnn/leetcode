class Solution {
    public String largestNumber(int[] nums) {
        String[] a = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            a[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(a, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                String s1 = a + b;
                String s2 = b + a;
                return s2.compareTo(s1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String s : a){
            sb.append(s);
        }
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}
