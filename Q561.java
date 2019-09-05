/*
* @Author: Shawn Yang
* @Date:   2019-09-05 16:34:22
* @Last Modified by:   Shawn Yang
* @Last Modified time: 2019-09-05 16:34:25
*/
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for(int i = 0; i < nums.length; i+=2) {
            result += nums[i];
        }
        return result;
        
    }
}