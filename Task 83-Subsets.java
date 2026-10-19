import java.util.*;

public class Main {
    static List<List<Integer>> result = new ArrayList<>();

    static void backtrack(int[] nums, int index,
                          List<Integer> current) {
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, current);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        backtrack(nums, 0, new ArrayList<>());

        System.out.println(result);
    }
}
