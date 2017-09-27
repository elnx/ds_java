public class QueueAdaptor extends MyQueue{
    QueueAdaptor(MyDeque q) {
        this.queue = q;
    }
    public void enqueue(DLNode node) {
        this.queue.insertLast(node);
    }
    public DLNode dequeue() {
        return this.queue.removeFirst();
    }
    public DLNode front() {
        return this.queue.first();
    }
    public int size() {
        return this.queue.size();
    }
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }
    public String toString() {
        return this.queue.toString();
    }
}
