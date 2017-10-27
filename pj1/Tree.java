public class Tree {
    int data;
    Tree parent, lc, rc;
    public Tree(int data, Tree parent, Tree lc, Tree rc) {
        this.data = data;
        this.parent = parent;
        this.lc = lc;
        this.rc = rc;
    }
    public Tree(int data) {
        this.data = data;
        this.parent = null;
        this.lc = null;
        this.rc = null;
    }
    public isLeaf() {
        return (lc == null) && (rc == null);
    }
}
