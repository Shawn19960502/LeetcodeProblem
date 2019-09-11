/*
* @Author: Shawn Yang
* @Date:   2019-09-11 14:05:33
* @Last Modified by:   Shawn Yang
* @Last Modified time: 2019-09-11 14:05:42
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
    public int ans;
    public int distributeCoins(TreeNode root) {
        if(root == null) {
            return 0;
        }
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }
}