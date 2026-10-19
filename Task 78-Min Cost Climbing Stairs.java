import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] cost = new int[n];

        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
        }

        int prev2 = 0;
        int prev1 = 0;

        for (int i = 2; i <= n; i++) {
            int current = Math.min(
                prev1 + cost[i - 1],
                prev2 + cost[i - 2]
            );

            prev2 = prev1;
            prev1 = current;
        }

        System.out.println(prev1);
    }
}
