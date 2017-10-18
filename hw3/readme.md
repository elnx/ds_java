# DS Homework 3
WANG Zhenghe 17212010075

## Josephus problem

A trivial solution:

$$ f(m, n) = (f(m, n-1) + m) mod(n) $$

```java
public class Josephus {
    public static void main(String[] args) {
        int m = Integer.valueOf(args[0]);
        int n = Integer.valueOf(args[1]);
        System.out.printf("f(%d, %d) = %d", m, n, solve(m, n));
    }
    public static int solve(int m, int n) {
        if (m == 0)
            return n;
        int f = 0;
        for (int i = 1; i <= n; ++i) {
            f = (f + m) % i;
        }
        return f+1;
    }
}
```
Time complexity is $O(n)$, space complexity is $O(1)$

## 3.11 Single Linked List
`Node.java`
```java
public class Node {
    int value;
    Node next;
    Node(int v) {
        this.value = value;
        this.next = null;
    }
}
```

`List.java`
```java
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
```
## 3.25a
Maintain a stack to `push` or `pop` every `current min` when do `push` or `pop`.

## 3.37

