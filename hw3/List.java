import java.util.Formatter;
public class List {
    Node head;
    int size;
    public List() {
        this.head = new Node(-1);
        head.next = null;
        this.size = 0;
    }
    public int getSize() {
        return this.size;
    }
    public boolean exist(int v) {
        if (this.size == 0) return false;
        Node p = this.head.next;
        while (p != null) {
            if (p.value == v) return true;
            p = p.next;
        }
        return false;

    }
    public boolean add(int v) {
        if (this.exist(v)) 
            return false;
        Node node = new Node(v);
        node.next = this.head;
        this.head = node;
        this.size++;
        return true;
    }
    public boolean remove(int v) {
        if (this.size == 0) return false;
        Node prev = this.head;
        Node p = this.head.next;
        while (p != null) {
            if (p.value == v) {
                prev.next = p.next;
                this.size--;
                return true;
            }
            p = p.next;
            prev = prev.next;
        }
        return false;
    }
    public String toString() {
        Formatter fmt = new Formatter();
        for (Node p = this.head.next; p != null; p = p.next) {
            fmt.format(
                "%d%c",
                p.value,
                p.next == null ? '\n': ' '
            );
        }
        return fmt.toString();
    }
}
