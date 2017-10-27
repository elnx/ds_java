import java.util.*;
import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileReader;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.io.Reader;  
public class Main {
    public static void main(String[] args) {
        String filename = args[0];
        File f = new File(filename);
        Reader reader = null;
        int[] list = new int[256];
        String text = "";
        try {
            reader = new InputStreamReader(new FileInputStream(f));
            int tmp;
            while ((tmp = reader.read()) != -1) {
                list[tmp] += 1;
                text += tmp;
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        PriorityQueue<Tree> q = new PriorityQueue<Tree> (
            256, 
            new Comparator<Tree>() {
                public int compare(Tree t1, Tree t2) {
                    return t1.count - t2.count;
                }
            }
        );
        for (int i = 0; i < 256; ++i) {
            if (list[i] != 0)
                q.add(new Tree(i, list[i]));
        }
        Huffman huffman = new Huffman(q);
        String compress = huffman.encode(text);
        System.out.println(compress);
        String decompress = huffman.decode(compress);
        System.out.println(decompress);
    }
}
