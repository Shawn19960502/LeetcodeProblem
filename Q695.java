/*
* @Author: Shawn Yang
* @Date:   2019-09-10 13:10:41
* @Last Modified by:   Shawn Yang
* @Last Modified time: 2019-09-10 13:10:44
*/
class Solution {
    public int maxRow;
    public int maxColumn;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int result = 0;
        maxRow = grid.length;
        maxColumn = grid[0].length;
        for(int i = 0; i < maxRow; i++) {
            for(int j = 0; j < maxColumn; j++) {
                if(grid[i][j] == 1) {
                    result = Math.max(dfsHelper(grid, i, j), result);
                }
            }
        }
        return result;
    }
    public int dfsHelper(int[][] grid, int row, int column) {
        if(row < 0 || column < 0 || row >= maxRow || column >= maxColumn || grid[row][column] == 0) {
            return 0;
        } else {
            grid[row][column] = 0;
            int left = dfsHelper(grid, row, column - 1);
            int right = dfsHelper(grid, row, column + 1);
            int top = dfsHelper(grid, row - 1, column);
            int bottom = dfsHelper(grid, row + 1, column);
            return 1 + left + right + top + bottom;
        }
    }
}