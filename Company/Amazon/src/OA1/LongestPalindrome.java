//Amazon OA
//http://www.lintcode.com/en/problem/longest-palindromic-substring/
//Note: iterating each char, take each char as center, compare the left chars with the right chars
// odd palindrome and even palindrome are different,  .....ADDA.....      ....ADCDA....
// We transform them to ....A#D-#-D#A....    ....A#D#-C-#D#A...., then we use center method everywhere
package OA1;
import java.util.*;

public class LongestPalindrome {
/*
    public static String longestPalindrome(String s) {

        if (s == null || s.length() < 1)
            return "";

        if (s.length() < 3)
            return s;

        int start = 0;
        int maxLength = 0;
        String res = "";

        for (int i = 1; i < s.length() * 2 - 1; i++) {
            int left = i - 1;
            int right = i + 1;

            while(left >= 0 && right <= s.length() - 1 && getChar(s, left) == getChar(s, right)) {
                left--;
                right++;
            }

            if (maxLength < right - left - 1) {
                maxLength = right - left - 1;
                start = left + 2;
            }
        }

        return s.substring(start, start + maxLength / 2);
    }

    private static char getChar(String s, int i) {
        if(i % 2 == 0)
            return '#';
        else
            return s.charAt(i / 2);
    }
*/
    String longest = "";
    int maxLength = 1;


    public String longestPalindrome(String s) {

        if (s == null || s.length() < 1)
            return "";

        if (s.length() < 3)
            return s;
        for (int i = 0; i < s.length() - 1; i++) {
            calculatePalindrome(s, i, i + 1); //test whether is the even case: ABCDE EDCBA  i : E  i + 1 : E(i is the first E             //when i is the second E, we don't treat is as palindrome
            calculatePalindrome(s, i, i);  //test whether is the odd case: ABCD E DCBA i: E
        }


        return longest;

    }

    private void calculatePalindrome(String s, int l, int r) {
        int left = l;
        int right = r;

        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        if (right - left - 1 > maxLength) {
            longest = s.substring(left + 1, right);
            maxLength = right - left - 1;
        }

    }


    public static void main(String[] args) {

        //String test = "wqrpoiuuiopcvx";
        //String test = "abcdefg";
        String test = "ccc";
        LongestPalindrome mm = new LongestPalindrome();
        String res = mm.longestPalindrome(test);
        System.out.println(res); //poiuuiop
    }

}
