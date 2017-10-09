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
