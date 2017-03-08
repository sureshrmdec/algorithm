package Test;
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

import java.util.*;
class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public static void sortColors2(int[] colors, int k) {
        if (colors == null || colors.length == 0) {
            return;
        }
        quickSort(colors, 0, colors.length - 1);
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right)
            return;

        int index = partition(nums, left, right);
        //if (left < index - 1)
            quickSort(nums, left, index - 1);
        //if (index < right)
            quickSort(nums, index, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int index = (left + right) / 2;
        int pivot = nums[index];

        while (left <= right) {
            while (nums[left] < pivot) {
                left++;
            }

            while (nums[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int temp;
                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }

        }

        return left;
    }

    private static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        int k = 4;
        int[] nums = {3,2,3,3,4,3,3,2,4,4,1,2,1,1,1,3,4,3,4,2};
        //int[] nums = {2,3,8,5,4,9,1,7};
        sortColors2(nums, k);
        print(nums);

    }
}
