/*
* @Author: Shawn Yang
* @Date:   2019-09-06 07:57:42
* @Last Modified by:   Shawn Yang
* @Last Modified time: 2019-09-06 07:57:46
*/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        int current = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            int pointer1 = i + 1;
            int pointer2 = nums.length - 1;
            if(nums[i] + nums[pointer1] + nums[pointer2] == target) {
                return target;
            }
            while(pointer1 < pointer2) {
                if(Math.abs(nums[pointer1] + nums[pointer2] + nums[i] - target) < result) {
                    current = nums[pointer1] + nums[pointer2] + nums[i];
                    result = Math.abs(current - target);
                }
                if(nums[pointer1] + nums[pointer2] + nums[i] - target >= 0) {
                    pointer2 -= 1;
                } else {
                    pointer1 += 1;
                }
            }
        }
        return current;
        
    }
}