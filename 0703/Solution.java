class KthLargest {
    private PriorityQueue<Integer> min;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        min = new PriorityQueue<>();
        for(int i : nums) add(i);
    }
    
    public int add(int val) {
        if(min.size() <  k){
            min.add(val);
        }else if(min.peek() < val) {
            min.poll(); 
            min.add(val) ;  
        }
        return min.peek();
    }
}

