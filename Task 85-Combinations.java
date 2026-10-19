import java.util.*;

public class Main {
    static List<List<Integer>> result = new ArrayList<>();

    static void backtrack(int n, int k, int start,
                          List<Integer> current) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);

            backtrack(n, k, i + 1, current);

            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        backtrack(n, k, 1, new ArrayList<>());

        System.out.println(result);
    }
}
