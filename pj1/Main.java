import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileReader;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.io.RandomAccessFile;  
import java.io.Reader;  
public class Main {
    public static void main(String[] args) {
        String filename = args[0];
        File f = new File(filename);
        Reader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(f));
            int tmp;
            while ((tmp = reader.read()) != -1) {
                System.out.printf("get: %02x\n", tmp);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
