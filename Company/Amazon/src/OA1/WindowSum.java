//Amazon OA
//Cannot find on lintcode
package OA1;
import java.util.*;

public class WindowSum {

    public static ArrayList<Integer> windowSum(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0 || nums.length < k)
            return res;

        int sum = 0;

        int i = 0;

        for (; i < k; i++) {
            sum += nums[i];
        }
        res.add(sum);


        while(i < nums.length) {
            sum = sum + nums[i] - nums[i - k];
            res.add(sum);
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] test = {2, 4, 5, 1, 7, 9, 4, 1, 10, 12};
        ArrayList res = windowSum(test, 4);

        System.out.println(res);
        //[12, 17, 22, 21, 21, 24, 27]



    }
}
