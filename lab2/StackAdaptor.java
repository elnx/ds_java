public class StackAdaptor extends MyStack{
    StackAdaptor(MyDeque q) {
        this.stack = q;
    }
    public void push(DLNode node) {
        this.stack.insertLast(node);
    }
    public DLNode pop() {
        return this.stack.removeLast();
    }
    public DLNode top() {
        return this.stack.last();
    }
    public int size() {
        return this.stack.size();
    }
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }
    public String toString() {
        return this.stack.toString();
    }
}
