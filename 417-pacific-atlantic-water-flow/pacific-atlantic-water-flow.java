class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int m = heights.length, n = heights[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               
                if (bfsPacific(heights, i, j) && bfsAtlantic(heights, i, j)) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }
        return result;
    }
    public boolean bfsPacific(int[][] heights, int i, int j) {
        int m = heights.length, n = heights[0].length;
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.add(new Pair(i, j));
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            Pair p = queue.remove();
            int x = p.i, y = p.j;

         
            if (x == 0 || y == 0) return true;
            if (x + 1 < m && !visited[x + 1][y] && heights[x + 1][y] <= heights[x][y]) {
                queue.add(new Pair(x + 1, y));
                visited[x + 1][y] = true;
            }
            if (x - 1 >= 0 && !visited[x - 1][y] && heights[x - 1][y] <= heights[x][y]) {
                queue.add(new Pair(x - 1, y));
                visited[x - 1][y] = true;
            }
            if (y + 1 < n && !visited[x][y + 1] && heights[x][y + 1] <= heights[x][y]) {
                queue.add(new Pair(x, y + 1));
                visited[x][y + 1] = true;
            }
            if (y - 1 >= 0 && !visited[x][y - 1] && heights[x][y - 1] <= heights[x][y]) {
                queue.add(new Pair(x, y - 1));
                visited[x][y - 1] = true;
            }
        }
        return false;
    }

 
    public boolean bfsAtlantic(int[][] heights, int i, int j) {
        int m = heights.length, n = heights[0].length;
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.add(new Pair(i, j));
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            Pair p = queue.remove();
            int x = p.i, y = p.j;

            if (x == m - 1 || y == n - 1) return true;

        
            if (x + 1 < m && !visited[x + 1][y] && heights[x + 1][y] <= heights[x][y]) {
                queue.add(new Pair(x + 1, y));
                visited[x + 1][y] = true;
            }
            if (x - 1 >= 0 && !visited[x - 1][y] && heights[x - 1][y] <= heights[x][y]) {
                queue.add(new Pair(x - 1, y));
                visited[x - 1][y] = true;
            }
            if (y + 1 < n && !visited[x][y + 1] && heights[x][y + 1] <= heights[x][y]) {
                queue.add(new Pair(x, y + 1));
                visited[x][y + 1] = true;
            }
            if (y - 1 >= 0 && !visited[x][y - 1] && heights[x][y - 1] <= heights[x][y]) {
                queue.add(new Pair(x, y - 1));
                visited[x][y - 1] = true;
            }
        }
        return false;
    }
}

class Pair {
    int i, j;
    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
