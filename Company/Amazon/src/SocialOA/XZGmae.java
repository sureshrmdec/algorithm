package SocialOA;
import java.util.*;

/**
 * 丢棒球砸砖块，貌似是地里没有出现过的题，输入是一个字符串数组，每一个值可能是一个整数，或者Z，或者X，或者+。
 * 整数代表现在拿的分，X代表当前成绩是前一个分数Double，+代表当前成绩是前两个的和，Z代表移除前一个成绩，然后要求的是最后的总成绩
 5 : sum = 5
 -2 : sum = 5 - 2 = 3
 4 : sum = 3 + 4 = 7
 Z : sum = 7 - 4 = 3
 X : sum = 3 + -2 * 2 = -1 (因为4被移除了，前一个成绩是-2)
 9 : sum = -1 + 9 = 8
 + : sum = 8 + 9 - 4 = 13 (前两个成绩是9和-4)
 + : sum = 13 + 9 + 5 = 27 (前两个成绩是5 和 9)
 */

public class XZGmae {
    private static int beginGame(String[] input) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("Z")) {
                if (!stack.isEmpty())
                    stack.pop();
            }
            else if (input[i].equals("X")) {
                if (!stack.isEmpty())
                    stack.push(stack.peek() * 2);
            }
            else if (input[i].equals("+")) {
                int temp1 = stack.pop();
                int temp2 = stack.peek();
                stack.push(temp1);
                stack.push(temp1 + temp2);
            }
            else
                stack.push(Integer.valueOf(input[i]));
        }

        int sum = 0;
        while(!stack.isEmpty())
            sum += stack.pop();

        return sum;

    }

    public static void main(String[] args) {
        String[] testArray = {"5", "-2", "4", "Z", "X", "9", "+", "+"};
        System.out.print("sum is : " + beginGame(testArray));
    }

}
