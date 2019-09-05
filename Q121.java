/*
* @Author: Shawn Yang
* @Date:   2019-09-05 16:52:08
* @Last Modified by:   Shawn Yang
* @Last Modified time: 2019-09-05 17:01:02
*/
class Solution {
    public int maxProfit(int[] prices) {
        // Divide and Conquer
        if(prices == null || prices.length == 0) {
            return 0;
        }
        return helper(prices, 0, prices.length - 1);
    }
    public int helper(int[] prices, int start, int end) {
        if(start == end) {
            return 0;
        }
        int middle = (start + end) / 2;
        int left = helper(prices, start, middle);
        int right = helper(prices, middle + 1, end);
        int crossValue = cross(prices, start, end, middle);
        return Math.max(Math.max(left, right), crossValue);
    }
    public int cross(int[] prices, int start, int end, int middle) {
        if(start == end) {
            return 0;
        }
        int minLeft = Integer.MAX_VALUE;
        for(int i = start; i < middle + 1; i++) {
            minLeft = Math.min(minLeft, prices[i]);
        }
        int maxRight = Integer.MIN_VALUE;
        for(int i = middle + 1; i < end + 1; i++) {
            maxRight = Math.max(maxRight, prices[i]);
        }
        
        return maxRight - minLeft >= 0 ? maxRight - minLeft : 0;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        // One Pass
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int maxPro = 0;
        int buy = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] > buy) {
                maxPro = Math.max(maxPro, prices[i] -  buy);
            } else {
                buy = prices[i];
            }
        }
        return maxPro;
}
}