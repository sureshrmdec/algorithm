package SocialOA;
import java.util.*;
// Amazon OA
//http://www.lintcode.com/en/problem/valid-parentheses/#
public class ValidParenthese {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public static boolean isValidParentheses(String s) {
        if(s == null || s.length() == 0 || s.length() % 2 != 0 )
            return false;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[' || ch == '(' || ch == '{') {
                stack.push(ch);
            } else if (stack.isEmpty() && (ch == ']' || ch == ')' || ch == '}')) {
                return false;
            } else if (ch == ']' && stack.peek() == '[') {
                stack.pop(); // don't forget this pop action
            } else if (ch == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (ch == '}' && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty(); // in case that left is more than right
    }

    public static void main(String[] args) {
        String test;
        boolean res;

        test = "{{{{[[(())]]}}}}";
        res = isValidParentheses(test);
        System.out.println(test + " " + res);

        test = "{{{{[(())]]}}}}";
        res = isValidParentheses(test);
        System.out.println(test + " " + res);

        test = "{";
        res = isValidParentheses(test);
        System.out.println(test + " " + res);

        test = "}";
        res = isValidParentheses(test);
        System.out.println(test + " " + res);

    }
}