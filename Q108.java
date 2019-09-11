/*
* @Author: Shawn Yang
* @Date:   2019-09-12 01:17:51
* @Last Modified by:   Shawn Yang
* @Last Modified time: 2019-09-12 01:18:03
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helperBST(nums, 0, nums.length - 1);
    }
    public TreeNode helperBST(int[] nums, int start, int end) {
        if(start == end) {
            return new TreeNode(nums[start]);
        }
        else if(end - start == 1) {
            TreeNode current = new TreeNode(nums[end]);
            current.left = new TreeNode(nums[start]);
            return current;
        }
        else if(end < start) {
            return null;
        }
        else {
            int middle = (end + start) / 2;
            TreeNode current = new TreeNode(nums[middle]);
            current.left = helperBST(nums, start, middle - 1);
            current.right = helperBST(nums, middle + 1, end);
            return current;
        }
    }
}