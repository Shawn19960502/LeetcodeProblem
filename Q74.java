/*
* @Author: Shawn Yang
* @Date:   2019-09-23 01:31:07
* @Last Modified by:   Shawn Yang
* @Last Modified time: 2019-09-23 01:31:12
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int columns = matrix[0].length - 1;
        int row = binaryFindRow(matrix, target, 0, matrix.length - 1, columns);
        if(row == -1) {
            return false;
        }
        return isConsist(matrix[row], 0, columns, target);
        
    }
    public int binaryFindRow(int[][] matrix, int target, int start,int end, int columns) {
        
        if(start > end) {
            return -1;
        }
        int middle = (start + end) / 2;
        if(matrix[middle][0] <= target && matrix[middle][columns] >= target) {
            return middle;    
        } else if (matrix[middle][0] > target) {
            return binaryFindRow(matrix, target, start, middle - 1, columns);
        }
        else {
            return binaryFindRow(matrix, target, middle + 1, end, columns);
        }
    }
    public boolean isConsist(int[] row, int start, int end, int target) {
        if(start > end) {
            return false;
        }
        int middle = (start + end) / 2;
        if(row[middle] == target) {
            return true;
        } else if(row[middle] > target) {
            return isConsist(row, start, middle - 1, target);
        } else {
            return isConsist(row, middle + 1, end, target);
        }       
    }
}