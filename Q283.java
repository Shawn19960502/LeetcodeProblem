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