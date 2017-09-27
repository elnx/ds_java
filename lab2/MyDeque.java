import java.util.Formatter;
public class MyDeque { 
    int size;
    DLNode first;
    DLNode last;
    //create a deque 
    MyDeque(DLNode node) {
        int size = 1;
        this.first = node;
        this.last = node;
        node.prev = null;
        node.next = null;
    }
    //insert a node at the beginning of deque 
    public void insertFirst(DLNode node) {
        if (this.isEmpty()) {
            this.size = 1;
            this.first = node;
            this.last = node;
            return;
        }
        node.next = this.first;
        this.first.prev = node;
        this.first = node;
        node.prev = null;
        ++size;
    }
    //remove and return the first node 
    public DLNode removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        if (this.size == 1) {
            DLNode tmp = this.first;
            this.size = 0;
            this.first = null;
            this.last = null;
            return tmp;
        }
        DLNode tmp = this.first;
        this.first = this.first.next;
        this.first.prev = null;
        tmp.prev = null;
        tmp.next = null;
        --this.size;
        return tmp;
    }
    //insert a node at the end of deque 
    public void insertLast(DLNode node) {
        this.last.next = node;
        node.prev = this.last;
        node.next = null;
        this.last = node;
    }
    //remove and return the last node 
    public DLNode removeLast() {
        if (this.isEmpty())
            return null;
        if (this.size == 1) {
            this.size = 0;
            DLNode tmp = this.last;
            this.first = null;
            this.last = null;
            tmp.prev = null;
            tmp.next = null;
            return tmp;
        }
        DLNode tmp = this.last;
        this.last = this.last.prev;
        this.last.next = null;
        tmp.prev = null;
        tmp.next = null;
        --this.size;
        return tmp;
    }
    //return first node 
    public DLNode first() {
        return this.first;
    }
    //return last node 
    public DLNode last() {
        return this.last;
    }
    //return number of nodes 
    public int size() {
        return this.size;
    }
    //judge whether the deque is empty 
    public boolean isEmpty() {
        if (this.size == 0)
            return true;
        return false;
    }
    //display content of the deque
    public String toString() {
        String s = "";
        Formatter fmt = new Formatter();
        DLNode p = this.first;
        while (p != null) {
            fmt.format("%d%c", p.element, p.next == null ? '\n': '-');
            p = p.next;
        }
        return fmt.toString();
    }
}
