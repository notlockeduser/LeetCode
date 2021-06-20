package _11_Container_With_Most_Water;

public class Solution11 {
    public static void main(String[] args) {
        //int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        //int[] height = {1, 1};
        int[] height = {1, 2, 4, 3};
        System.out.println(maxAreaLong(height));
        System.out.println(maxAreaFast(height));
    }

    public static int maxAreaFast(int[] height) {
        int maxArea = 0, left = 0, right = height.length - 1;
        while (left != right) {
            maxArea = Math.max(maxArea, Math.min(height[right], height[left]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }


    public static int maxAreaLong(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int temp = Math.min(height[j], height[i]) * (j - i);
                if (maxArea < temp) {
                    maxArea = temp;
                }
            }
        }
        return maxArea;
    }
}
