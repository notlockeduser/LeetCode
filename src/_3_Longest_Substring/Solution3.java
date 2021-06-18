package _3_Longest_Substring;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public static void main(String[] args) {
        //String input = "pwwkew";
        //String input = "bbbbb";
        //String input = "";
        //String input = " ";
        //String input = "au";
        String input = "abcabcbb";

        int n = input.length();
        char[] chars = input.toCharArray();
        int output = 0;
        int left = 0, right = 0;
        Map<Character, Boolean> dictionary = new HashMap<>();

        while (right < n) {
            if (dictionary.getOrDefault(chars[right], true)) {
                dictionary.put(chars[right], false);
            } else {
                dictionary.remove(chars[left]);
                left++;
                continue;
            }
            output = Math.max(output, right - left + 1);
            right++;
        }

        //return output;
        System.out.println(output);
    }
}
