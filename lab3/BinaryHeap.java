public class BinaryHeap {
    //create a BinaryHeap
    int capacity;
    int size;
    int[] heap;
    public BinaryHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity+1];
    }
    public BinaryHeap(int[] items) {
        for (int i = 0; i < items.length; ++i) {
            this.insert(items[i]);
        }
    }
    //insert a element into the heap
    public void insert(int x) {
        if (this.size == this.capacity)
            return; // heap is full
        int i = ++this.size;
        for (; i > 1 && x < heap[i/2]; i /= 2)
            heap[i] = heap[i/2];
        heap[i] = x;
    }
    //return the minimum element
    public int findMin() throws EmptyException {
        return heap[1];
    }
    //remove and return the minimum element
    public int deleteMin() throws EmptyException {
        if (this.isEmpty())
            throws new EmptyException("heap is empty");
        int min = heap[1];
        heap[1] = heap[this.size];
        --this.size;
        int i = 1;
        int lc = 0;
        int tmp = heap[1];
        for (; (i<<1) <= this.size; i = lc) {
            lc = i<<1;
            if (lc != this.size && heap[lc+1] < heap[lc]) 
                ++lc;
            if (heap[lc] < tmp) {
                heap[i] = heap[lc];
            } else {
                break;
            }
        }
        heap[i] = tmp;
        return min;
    }
    //judge whether the heap is empty
    public boolean isEmpty() {
        return this.size == 0;
    }
    public boolean isFull() {
        return this.size == this.capacity;
    }
    //remove all elements
    public void makeEmpty() {
        this.size = 0;
    }
}
