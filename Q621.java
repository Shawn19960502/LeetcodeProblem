/*
* @Author: Shawn Yang
* @Date:   2019-09-19 07:43:27
* @Last Modified by:   Shawn Yang
* @Last Modified time: 2019-09-19 07:43:40
*/
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        int time = 0;
        while (map[25] > 0) {
            map[25] -= 1;
            time += 1;
            int i = 1;
            while(i <= n && map[25] > 0) {
                if(i <= 25 && map[25 - i] > 0) {
                    map[25 - i] -= 1;
                }
                time += 1;
                i += 1;
            }
            Arrays.sort(map);
        }
        return time;
    }
}