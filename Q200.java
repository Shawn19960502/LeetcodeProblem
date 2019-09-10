class Solution {
    public int maxRow;
    public int maxColumn;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        maxRow = grid.length;
        maxColumn = grid[0].length;
        boolean[][] visited = new boolean[maxRow][maxColumn];
        int result = 0;
        for(int i = 0; i < maxRow; i++) {
            for(int j = 0; j < maxColumn; j++) {
                if(visited[i][j] || grid[i][j] == '0') {
                    continue;
                } else {
                    result += 1;
                    dfsHelper(visited, i, j, grid);
                }
            }
        }
        return result;
    }
    public void dfsHelper(boolean[][] visited, int row, int column, char[][] grid) {
        if(row < 0 || column < 0 || row >= maxRow || column >= maxColumn || visited[row][column] == true || grid[row][column] == '0') {
            return;
        } else {
            visited[row][column] = true;
            dfsHelper(visited, row + 1, column, grid);
            dfsHelper(visited, row, column + 1, grid);
            dfsHelper(visited, row - 1, column, grid);
            dfsHelper(visited, row, column - 1, grid);
        }
        
    }
}