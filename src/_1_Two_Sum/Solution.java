package _1_Two_Sum;
// https://leetcode.com/problems/two-sum

class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }

        //return result;
        for (int num : nums){
            System.out.println(num);
        }
    }
}