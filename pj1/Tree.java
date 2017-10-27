public class Tree {
    int data;
    int count;
    Tree parent, lc, rc;
    public Tree(int data, int count, Tree parent, Tree lc, Tree rc) {
        this.data = data;
        this.count = count;
        this.parent = parent;
        this.lc = lc;
        this.rc = rc;
    }
    public Tree(int data, int count, Tree lc, Tree rc) {
        this.data = data;
        this.count = count;
        this.parent = null;
        this.lc = lc;
        this.rc = rc;
    }
    public Tree(int data, int count) {
        this.data = data;
        this.count = count;
        this.parent = null;
        this.lc = null;
        this.rc = null;
    }
    public boolean isLeaf() {
        return (lc == null) && (rc == null);
    }
}
