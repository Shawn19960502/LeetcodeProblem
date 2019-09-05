/*
* @Author: Shawn Yang
* @Date:   2019-09-05 16:17:38
* @Last Modified by:   Shawn Yang
* @Last Modified time: 2019-09-05 16:17:43
*/
class Solution {
// divide conquer
  public int maxSubArray(int[] nums) {
      return helper(nums, 0 , nums.length - 1);
  }
  public int helper(int[] nums, int start, int end) {
      if(start == end) {
          return nums[start];
      }
      int middle = (start + end) / 2;
      int left = helper(nums, start, middle);
      int right = helper(nums, middle + 1, end);
      int d = cross(nums, start, end, middle);
      return Math.max(Math.max(left,right),d);
  }
  public int cross(int[] nums, int start, int end, int middle) {
      int leftSubsum = Integer.MIN_VALUE;
      int currSum = 0;
      for(int i = middle; i > start - 1; i--) {
          currSum += nums[i];
          leftSubsum = Math.max(leftSubsum, currSum);
      }
      int rightSubsum = Integer.MIN_VALUE;
      currSum = 0;
      for(int i = middle + 1; i < end + 1; i++) {
          currSum += nums[i];
          rightSubsum = Math.max(rightSubsum, currSum);
      }
      return leftSubsum + rightSubsum;
  }
}