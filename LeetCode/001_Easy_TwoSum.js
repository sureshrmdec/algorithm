/**
 *  Two Sum
 *  Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *  You may assume that each input would have exactly one solution.
 * for example
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
"use strict"
var twoSum = function(nums, target) {
    let result = [];
    let len = nums.length;
    let i, j;
    for (i = 0; i < len - 1; i++) {
        for (j = i + 1; j < len; j++) {
            if (nums[i] + nums[j] === target) {
                result.push(i);
                result.push(j);
                return result;
            }

        }
    }
};
//testing
let nums = [2, 4, 6, 7, 1, 3];
console.log(twoSum(nums, 9));
