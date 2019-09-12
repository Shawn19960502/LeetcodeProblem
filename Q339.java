/*
* @Author: Shawn Yang
* @Date:   2019-09-12 10:14:12
* @Last Modified by:   Shawn Yang
* @Last Modified time: 2019-09-12 10:14:17
*/
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }
    public int dfs(List<NestedInteger> nestedList, int depth) {
        int res = 0;
        for(NestedInteger ni : nestedList) {
            if(ni.isInteger()) {
                res += ni.getInteger() * depth;
            } else {
                res += dfs(ni.getList(), depth + 1);
            }
        }
        return res;
    }
}