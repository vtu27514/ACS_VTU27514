import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int redCount = sc.nextInt();
        int blueCount = sc.nextInt();

        List<Integer>[] red = new ArrayList[n];
        List<Integer>[] blue = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            red[i] = new ArrayList<>();
            blue[i] = new ArrayList<>();
        }

        for (int i = 0; i < redCount; i++) {
            red[sc.nextInt()].add(sc.nextInt());
        }

        for (int i = 0; i < blueCount; i++) {
            blue[sc.nextInt()].add(sc.nextInt());
        }

        int[][] dist = new int[n][2];
        for (int[] d : dist) Arrays.fill(d, -1);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        q.offer(new int[]{0, 1});

        dist[0][0] = 0;
        dist[0][1] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int color = cur[1];

            List<Integer> nextNodes =
                    color == 0 ? blue[node] : red[node];

            for (int next : nextNodes) {
                if (dist[next][1 - color] == -1) {
                    dist[next][1 - color] = dist[node][color] + 1;
                    q.offer(new int[]{next, 1 - color});
                }
            }
        }

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            if (dist[i][0] == -1) answer[i] = dist[i][1];
            else if (dist[i][1] == -1) answer[i] = dist[i][0];
            else answer[i] = Math.min(dist[i][0], dist[i][1]);
        }

        System.out.println(Arrays.toString(answer));
    }
}
