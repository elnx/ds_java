
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestBST {
    @Test
    public void testBST(){
        String[] a = {"Hello", "World", "Java", "Data", "Structure", "Algorithm", "Merry", "Christmas"};
        int n = a.length;
        BST<String, Integer> st = new BST<String, Integer>();
        for (int i = 0; i < n; i++)
            st.put(a[i], i);
        StringBuilder sb = new StringBuilder();
        for (String s : st.keys())
            sb.append(s).append(" ").append(st.get(s)).append("\n");
        assertEquals("Algorithm 5\n" +
                "Christmas 7\n" +
                "Data 3\n" +
                "Hello 0\n" +
                "Java 2\n" +
                "Merry 6\n" +
                "Structure 4\n" +
                "World 1\n", sb.toString());
        BST<Integer, String> bst = new BST<>();
        bst.put(1, "One");
        bst.put(5, "Five");
		bst.put(0, "Zero");
		bst.put(16, "Sixteen");
		bst.put(4, "Four");
		bst.put(7, "Seven");
		bst.put(2, "Two");
		bst.put(6, "Siix");
		bst.put(6, "Six");
		bst.put(11, "Eleven");
		bst.put(1225, "Merry Christmas");
		sb.delete(0, sb.length());
		for (Integer i: bst.keys())
		    sb.append(i).append(" ").append(bst.get(i)).append("\n");
		assertEquals("0 Zero\n" +
                "1 One\n" +
                "2 Two\n" +
                "4 Four\n" +
                "5 Five\n" +
                "6 Six\n" +
                "7 Seven\n" +
                "11 Eleven\n" +
                "16 Sixteen\n" +
                "1225 Merry Christmas\n", sb.toString());
    }
}
