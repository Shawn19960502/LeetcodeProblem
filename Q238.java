/*
* @Author: Shawn Yang
* @Date:   2019-09-05 20:51:06
* @Last Modified by:   Shawn Yang
* @Last Modified time: 2019-09-05 20:51:12
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        int[] result = new int[nums.length];
        int left = 1;
        result[0] = left;
        for(int i = 1; i < nums.length; i++){
            left = left * nums[i - 1];
            result[i] = left;
        }
        int right = 1;
        for(int j = nums.length - 1; j >= 0; j--) {
            result[j] = result[j] * right;
            right = nums[j] * right;
        }
        return result;
        
    }
}