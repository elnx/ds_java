import java.util.*;
public class Huffman {
    Tree root;
    String[] map;
    public Huffman(PriorityQueue<Tree> q) {
        while (q.size() > 1) {
            Tree a = q.poll();
            Tree b = q.poll();
            Tree c = new Tree(-1, a.count+b.count, a, b);
            q.add(c);
        }
        this.root = q.poll();
        this.map = new String[256];
        this.probe(this.root, "");
    }
    public void probe(Tree root, String code) {
        if (root.isLeaf()) {
            this.map[root.data] = code;
            System.out.printf("map[%02x, %d] -> %s\n", root.data, root.count, code);
            return;
        }
        String lcode = code + "0";
        String rcode = code + "1";
        probe(root.lc, lcode);
        probe(root.rc, rcode);
    }
    public String encode(String text) {
        String compress = "";
        for (int i = 0; i < text.length(); ++i) {
            compress += this.map[(int)text.charAt(i)];
        }
        return compress;
    }
    public String decode(String compressedText) {
        Tree p = this.root;
        String text = "";
        for (int i = 0; i < compressedText.length();) {
            while (!p.isLeaf()) {
                if (compressedText.charAt(i) == '0') {
                    p = p.lc;
                } else {
                    p = p.rc;
                }
                ++i;
            }
            text += (char)p.data;
            p = this.root;
        }
        return text;
    }
}
