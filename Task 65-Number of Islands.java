import java.util.*;

public class Main {
    static void dfs(char[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;

        if (r < 0 || r >= m || c < 0 || c >= n
                || grid[r][c] != '1') {
            return;
        }

        grid[r][c] = '0';

        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        char[][] grid = new char[m][n];

        for (int i = 0; i < m; i++) {
            grid[i] = sc.next().toCharArray();
        }

        int islands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    dfs(grid, i, j);
                }
            }
        }

        System.out.println(islands);
    }
}
