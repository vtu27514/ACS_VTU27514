import java.util.*;

public class Main {
    static void dfs(int[][] image, int r, int c,
                    int oldColor, int newColor) {
        if (r < 0 || r >= image.length ||
            c < 0 || c >= image[0].length ||
            image[r][c] != oldColor) {
            return;
        }

        image[r][c] = newColor;

        dfs(image, r + 1, c, oldColor, newColor);
        dfs(image, r - 1, c, oldColor, newColor);
        dfs(image, r, c + 1, oldColor, newColor);
        dfs(image, r, c - 1, oldColor, newColor);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] image = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                image[i][j] = sc.nextInt();
            }
        }

        int sr = sc.nextInt();
        int scCol = sc.nextInt();
        int color = sc.nextInt();

        int oldColor = image[sr][scCol];

        if (oldColor != color) {
            dfs(image, sr, scCol, oldColor, color);
        }

        for (int[] row : image) {
            System.out.println(Arrays.toString(row));
        }
    }
}
