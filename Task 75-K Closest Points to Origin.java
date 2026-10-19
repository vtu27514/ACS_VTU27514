import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] points = new int[n][2];

        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        int k = sc.nextInt();

        Arrays.sort(points, (a, b) ->
            Long.compare(
                (long) a[0] * a[0] + (long) a[1] * a[1],
                (long) b[0] * b[0] + (long) b[1] * b[1]
            )
        );

        for (int i = 0; i < k; i++) {
            System.out.println(
                "[" + points[i][0] + ", " + points[i][1] + "]"
            );
        }
    }
}
