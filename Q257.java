/*
* @Author: Shawn Yang
* @Date:   2019-09-12 03:09:11
* @Last Modified by:   Shawn Yang
* @Last Modified time: 2019-09-12 03:09:44
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


/********************** So Slow Method ***************/
class Solution {
    Stack<Integer> stack;
    List<String> results;
    public List<String> binaryTreePaths(TreeNode root) {
        stack = new Stack<>();
        results = new LinkedList<>();
        if(root != null) {
            dfs(root);
        }
        return results;
        
    }
    public void dfs(TreeNode root) {
        if(root.left == null && root.right == null) {
            stack.push(root.val);
            addToResult();
            stack.pop();
        }
        else if(root.left == null && root.right != null) {
            stack.push(root.val);
            dfs(root.right);
            stack.pop();
        }
        else if(root.left != null && root.right == null) {
            stack.push(root.val);
            dfs(root.left);
            stack.pop();
        } else {
            stack.push(root.val);
            dfs(root.left);
            dfs(root.right);
            stack.pop();
        }
    }
    public void addToResult() {
        String result = "";
        for(Integer num: stack) {
            result += String.valueOf(num);
            result += "->";
        }
        result = result.substring(0, result.length() - 2);
        results.add(result);
    }
}
