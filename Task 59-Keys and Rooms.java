import java.util.*;

public class Main {
    static void dfs(int room, List<List<Integer>> rooms,
                    boolean[] visited) {
        visited[room] = true;

        for (int key : rooms.get(room)) {
            if (!visited[key]) {
                dfs(key, rooms, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<List<Integer>> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            rooms.add(new ArrayList<>());

            int k = sc.nextInt();

            for (int j = 0; j < k; j++) {
                rooms.get(i).add(sc.nextInt());
            }
        }

        boolean[] visited = new boolean[n];

        dfs(0, rooms, visited);

        for (boolean v : visited) {
            if (!v) {
                System.out.println("false");
                return;
            }
        }

        System.out.println("true");
    }
}
