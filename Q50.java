/*
* @Author: Shawn Yang
* @Date:   2019-09-23 00:19:50
* @Last Modified by:   Shawn Yang
* @Last Modified time: 2019-09-23 00:19:56
*/
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(N < 0) {
            N = -N;
            x = 1 / x;
        }
        return fastPow(x, n);
        
    }
    public double fastPow(double x, int n) {
        if(n == 0) {
            return 1.0;
        }
        if(n % 2 == 0) {
            double temp = fastPow(x, n / 2);
            return temp * temp;
        } else {
            double temp = fastPow(x, n / 2);
            return temp * temp * x;
        }
    }
}