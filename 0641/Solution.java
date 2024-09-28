class MyCircularDeque {
    private int[] a;
    private int i;
    private int j;
    private int n;
    private int size;

    public MyCircularDeque(int k) {
        n = k;
        a = new int[k];
        Arrays.fill(a, -1);
        i = 0;
        j = 0;
        size = 0;
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        i = shift(i - 1);
        a[i] = value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        a[j] = value;
        size++;
        j = shift(j + 1);
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        a[i] = -1;
        i = shift(i + 1);
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        j = shift(j - 1);
        a[j] = -1;
        size--;
        return true;
    }
    
    public int getFront() {
        return a[i];
    }
    
    public int getRear() {
        return a[shift(j - 1)];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == n ;
    }

    private int shift(int i){
        if(i < 0){
            return  n - 1;
        }else if( i == n){
            return 0;
        }
        return i;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
