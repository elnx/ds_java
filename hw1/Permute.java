public class Permute {
    public static void main(String[] args) {
        permute(args[0]);
    }
    public static void permute(String str) {
        permute(str.toCharArray(), 0, str.length());
    }
    public static void permute(char[] str, int low, int high) {
        if (high <= 1)
            return;
        if (low == high)
            System.out.println(str);
        else
            for (int i=low; i<high; ++i) {
                swap(str, i, low);
                permute(str, low+1, high);
                swap(str, low, i);
            }
    }
    public static void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
