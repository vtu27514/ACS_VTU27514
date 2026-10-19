import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        String[] strs = new String[size];

        for (int i = 0; i < size; i++) {
            strs[i] = sc.next();
        }

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] dp = new int[m + 1][n + 1];

        for (String s : strs) {
            int zeros = 0;
            int ones = 0;

            for (char c : s.toCharArray()) {
                if (c == '0') zeros++;
                else ones++;
            }

            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(
                        dp[i][j],
                        1 + dp[i - zeros][j - ones]
                    );
                }
            }
        }

        System.out.println(dp[m][n]);
    }
}
