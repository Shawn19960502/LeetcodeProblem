/*
* @Author: Shawn Yang
* @Date:   2019-09-11 12:19:15
* @Last Modified by:   Shawn Yang
* @Last Modified time: 2019-09-11 12:19:27
*/
class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        Stack<String> stack = new Stack<>();
        Stack<Integer> count = new Stack<>();
        int idx = 0;
        String result = "";
        int length = s.length();
        while(idx < length) {
            if(s.charAt(idx) - '0' >= 0 && s.charAt(idx) - '0' <= 9) {
                int num = 0;
                while(s.charAt(idx) - '0' >= 0 && s.charAt(idx) - '0' <= 9) {
                    num = s.charAt(idx) - '0' + num * 10;
                    idx += 1;
                }
                count.push(num);
            }
            else if(s.charAt(idx) == '[') {
                stack.push(result);
                result = "";
                idx += 1;
            }
            else if(s.charAt(idx) == ']') {
                String temp = stack.pop();
                int number = count.pop();
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < number; i++) {
                    sb.append(result);
                }
                result = temp + sb.toString();   
                idx += 1;
            }
            else {
                result = result + s.charAt(idx);
                idx += 1;
            }
            
        }
        return result;
        
        
    }
}