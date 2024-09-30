class CustomStack {
    private int[] a;
    private int i;
    public CustomStack(int maxSize) {
        a = new int[maxSize];
        i = -1;
    }
    
    public void push(int x) {
        if(i + 1 < a.length) a[++i] = x;
    }
    
    public int pop() {
        int res = -1;
        if(i >= 0) res = a[i--];    
        return res;
    }
    
    public void increment(int k, int val) {
        for(int j = 0; j < Math.min(a.length, k); j++) a[j] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
