public abstract class MyQueue{ 
    MyDeque queue;
    //push a node into queue 
    public abstract void enqueue(DLNode node);
    //pop a node from queue 
    public abstract DLNode dequeue();
    //return top node
    public abstract DLNode front();
    //return number of nodes 
    public abstract int size();
    //judge whether the queue is empty
    public abstract boolean isEmpty();
    //display the content of the queue
    public abstract String toString();
}
