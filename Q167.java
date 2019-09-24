/*
* @Author: Shawn Yang
* @Date:   2019-09-23 00:35:05
* @Last Modified by:   Shawn Yang
* @Last Modified time: 2019-09-23 00:35:08
*/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0) {
            return null;
        }
        int start = 0;
        int end = numbers.length - 1;
        while(start < end) {
            else if(numbers[start] + numbers[end] == target) {
                return new int[]{start + 1, end + 1};
            }
            else if(numbers[start] + numbers[end] > target) end -= 1;
            else start += 1;
        }
        return null;
    }
}