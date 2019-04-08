import java.util.*;
class Solution {
    public int[] plusOne(int[] digits) {
        int flag = 0;
        Stack<Integer> stack = new Stack<>();
        if(digits[digits.length - 1] == 9) {
            flag = 1;
            stack.push(0);
        } else {
            stack.push(digits[digits.length - 1] + 1);
        }

        for(int i = digits.length - 2; i >= 0; i--) {
            if(digits[i] + flag == 10) {
                stack.push(0);
                flag = 1;
            }
            else {
                stack.push(digits[i] + flag);
                flag = 0;
            }
        }
        if(flag == 1) {
            stack.push(1);
        }
        int[] res = new int[stack.size()];
        int length = stack.size();
        for(int i = 0; i < length; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
}