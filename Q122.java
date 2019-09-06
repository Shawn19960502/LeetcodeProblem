/*
* @Author: Shawn Yang
* @Date:   2019-09-06 08:00:43
* @Last Modified by:   Shawn Yang
* @Last Modified time: 2019-09-06 10:20:21
*/
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int valley = prices[0];
        int peak = prices[0];
        int result = 0;
        int i = 0;
        while(i < prices.length - 1) {
            while(i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            while(i < prices.length -1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];
            result += peak - valley;
        }
        return result;
        
    }
}