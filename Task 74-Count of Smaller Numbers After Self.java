import java.util.*;

public class Main {
    static int[] nums, indexes, temp, counts;

    static void mergeSort(int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        merge(left, mid, right);
    }

    static void merge(int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        int smaller = 0;

        while (i <= mid && j <= right) {
            if (nums[indexes[j]] < nums[indexes[i]]) {
                temp[k++] = indexes[j++];
                smaller++;
            } else {
                counts[indexes[i]] += smaller;
                temp[k++] = indexes[i++];
            }
        }

        while (i <= mid) {
            counts[indexes[i]] += smaller;
            temp[k++] = indexes[i++];
        }

        while (j <= right) {
            temp[k++] = indexes[j++];
        }

        for (int x = left; x <= right; x++) {
            indexes[x] = temp[x];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        nums = new int[n];
        indexes = new int[n];
        temp = new int[n];
        counts = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            indexes[i] = i;
        }

        mergeSort(0, n - 1);

        System.out.println(Arrays.toString(counts));
    }
}
