/*
* @Author: Shawn Yang
* @Date:   2019-09-17 14:13:29
* @Last Modified by:   Shawn Yang
* @Last Modified time: 2019-09-17 14:13:39
*/
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return new int[0][];
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        ArrayList<int[]> res = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        int length = intervals.length;
        for(int i = 1; i < length; i++) {
            if(intervals[i][0] <= end) {
                end = Math.max(intervals[i][1], end);
            } else {
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res.add(new int[]{start, end});
        int[][] result = new int[res.size()][];
        for(int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}