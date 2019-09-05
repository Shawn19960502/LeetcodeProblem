/*
* @Author: Shawn Yang
* @Date:   2019-09-05 20:59:45
* @Last Modified by:   Shawn Yang
* @Last Modified time: 2019-09-05 20:59:49
*/
class Solution {
    public int majorityElement(int[] nums) {
    // one pass  
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int current = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(count == 0) {
                current = nums[i];
                count = 1;
            }
            else if(current == nums[i]) {
                count += 1;
            } else {
                count -= 1;
            }
        }
        return current;
    }
}