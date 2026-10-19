import java.util.*;

public class Main {
    static List<List<Integer>> result = new ArrayList<>();

    static void backtrack(int[] nums, boolean[] used,
                          List<Integer> current) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                current.add(nums[i]);

                backtrack(nums, used, current);

                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        backtrack(nums, new boolean[n], new ArrayList<>());

        System.out.println(result);
    }
}
