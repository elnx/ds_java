import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

public class BST <Key extends Comparable<Key>, Value>{
    // root of BST
    private Node root = null;

    private class Node {
        private Key key;             // sorted by key
        private Value val;           // associated value
        private Node left, right;    // left and right subtrees

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }


    /***************************************************************************
     *  Insert key-value pair into symbol table.
     ***************************************************************************/
    public void put(Key key, Value val) {
        // your code here
    	if (this.root == null) {
    		this.root = new Node(key, val);
    		return;
    	}
    	Node p = this.root;
    	Node pp = null;
    	while (p != null) {
    		int a = key.compareTo(p.key);
    		if (a == 0) {
    			p.val = val;
    			return;
    		}
    		if (a < 0) {
    			pp = p;
        		p = p.left;
    		}
        	if (a > 0) {
        		pp = p;
        		p = p.right;
        	}	
    	}
    	Node n = new Node(key, val);
    	if (key.compareTo(pp.key) < 0) {
    		pp.left = n;
    		return;
    	} else {
    		pp.right = n;
    		return;
    	}
    	
    }


    /***************************************************************************
     *  Search BST for given key.
     ***************************************************************************/
    Value get(Key key) {
        // your code here
    	Node p = this.root;
    	while (p != null) {
        	//int a = p.key.compareTo(key);
        	int a = key.compareTo(p.key);
        	if (a == 0) {
        		return p.val;
        	}
        	if (a > 0) {
        		p = p.right;
        	}
        	if (a < 0) {
        		p = p.left;
        	}
    		
    	}
        return null;
    }

    /***************************************************************************
     *  Inorder traversal.
     ***************************************************************************/
    public Iterable<Key> keys() {
        Stack<Node> stack = new Stack<Node>();
        Queue<Key> queue = new LinkedBlockingDeque<>();
        Node x = root;
        while (x != null || !stack.isEmpty()) {
            if (x != null) {
                stack.push(x);
                x = x.left;
            }
            else {
                x = stack.pop();
                queue.add(x.key);
                x = x.right;
            }
        }
        return queue;
    }
}
