import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] score = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            score[a]--;
            score[b]++;
        }

        for (int i = 1; i <= n; i++) {
            if (score[i] == n - 1) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }
}
