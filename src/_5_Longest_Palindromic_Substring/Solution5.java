package _5_Longest_Palindromic_Substring;

public class Solution5 {
    public static void main(String[] args) {
        //String s = "abcabcbb";
        String s = "babad";
        //String s = "dddddddd";
        //String s = "cccc";
        System.out.println(longestPalindromeLong(s));
        System.out.println(longestPalindromeFast(s));

        //return result;
    }

    private static String longestPalindromeFast(String s) {
        int n = s.length();

        String resultStr = "";
        String resultStr2 = "";
        char[] chars = s.toCharArray();

        if (n == 1) {
            resultStr = s;
        } else {
            for (int i = 0; i < n - 1; i++) {
                resultStr = checkCenter(chars, i, 0, resultStr, s, n);
                resultStr2 = checkCenter(chars, i, 1, resultStr2, s, n);
            }
        }
        if (resultStr.length() < resultStr2.length())
            resultStr = resultStr2;
        return resultStr;
    }

    private static String checkCenter(char[] chars, int i, int tFlag, String resultStr, String s, int n) {
        int t = i;
        if (tFlag == 1) {
            t = i + 1;
        }
        if (chars[i] == chars[t]) {
            if (resultStr.length() < s.substring(i, t + 1).length())
                resultStr = s.substring(i, t + 1);
            int j = 1;
            while (i - j >= 0 && t + j < n && chars[i - j] == chars[t + j]) {
                if (resultStr.length() < s.substring(i - j, t + j + 1).length())
                    resultStr = s.substring(i - j, t + j + 1);
                j++;
            }
        }
        return resultStr;
    }

    public static String longestPalindromeLong(String s) {
        int n = s.length(), result = 0;
        String resultStr = null;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (checkPalindrom(s, i, j)) {
                    if (result < (j - i + 1)) {
                        result = j - i + 1;
                        resultStr = s.substring(i, j + 1);
                    }
                }
            }
        }
        return resultStr;
    }

    private static boolean checkPalindrom(String s, int start, int end) {
        char[] chars = s.toCharArray();
        for (int i = start, j = end; i <= j; i++, j--) {
            if (!(chars[i] == chars[j])) {
                return false;
            }
        }
        return true;
    }
}
