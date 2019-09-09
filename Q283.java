/*
* @Author: Shawn Yang
* @Date:   2019-09-06 17:36:19
* @Last Modified by:   Shawn Yang
* @Last Modified time: 2019-09-06 17:36:21
*/
class Solution {
    public void moveZeroes(int[] nums) {
    // two pointers;
        if(nums == null || nums.length == 0) {
            return;
        }
        int zeroPointer = 0;
        int noneZeroPointer = 0;
        int i = 0;
        while(i < nums.length - 1) {
            while(nums[i] != 0 && i < nums.length - 1) {i++;}
            int j = i + 1;
            while(j < nums.length && nums[j] == 0) {j++;}
            if(j == nums.length) {return;}
            else{
                nums[i] = nums[j];
                nums[j] = 0;
            }
        }
        return;
    }
}
class Solution {
    public void moveZeroes(int[] nums) {
    // two pointers;
        if(nums == null || nums.length == 0) {
            return;
        }
        int pointer = 0;
        for(int num : nums) {
            if(num != 0) {
                nums[pointer] = num;
                pointer += 1;
            }
        }
        for(int i = pointer; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}