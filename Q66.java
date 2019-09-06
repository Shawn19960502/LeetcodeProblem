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
class Solution {
    public int[] plusOne(int[] digits) {
        boolean flag = true;
        for(int i = 0; i < digits.length; i++) {
            if(digits[i] != 9) {
                flag = false;
                break;
            }
        }
        if(flag) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        } else {
            int[] result = new int[digits.length];
            int carry = 1;
            for(int i = digits.length - 1; i > -1; i--) {
                result[i] = (digits[i] + carry) % 10;
                if(digits[i] + carry >= 10) {
                    carry = 1;
                } else {
                    carry = 0;
                }
            }
            return result;
        }
        
    }
}