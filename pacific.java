import java.util.*;
class Solutionsss {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Pacific: top and left
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, pacific);
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, pacific);
        }

        // Atlantic: bottom and right
        for (int i = 0; i < m; i++) {
            dfs(heights, i, n - 1, atlantic);
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, m - 1, j, atlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();

        // Cells reachable from both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] visited) {

        if (visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        for (int[] dir : directions) {

            int nr = r + dir[0];
            int nc = c + dir[1];

            // Boundary check
            if (nr < 0 || nr >= heights.length ||
                nc < 0 || nc >= heights[0].length) {
                continue;
            }

            // Reverse flow:
            // next cell must be >= current cell
            if (heights[nr][nc] >= heights[r][c]) {
                dfs(heights, nr, nc, visited);
            }
        }
    }
}