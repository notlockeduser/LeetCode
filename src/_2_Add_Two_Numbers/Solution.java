package _2_Add_Two_Numbers;
// https://leetcode.com/problems/add-two-numbers/

class Solution {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 4, 9, 5, 5};
        int[] nums2 = {1, 2, 5};
        int i = 0;

        ListNode list1 = new ListNode(nums1[0]);
        ListNode list2 = new ListNode(nums2[0]);
        ListNode l1 = list1;
        ListNode l2 = list2;

        i = 1;
        while (i < nums1.length) {
            list1.next = new ListNode(nums1[i]);
            list1 = list1.next;
            i++;
        }

        i = 1;
        while (i < nums2.length) {
            list2.next = new ListNode(nums2[i]);
            list2 = list2.next;
            i++;
        }

        int shift = 0, sum = 0;
        ListNode result = null;
        sum = (l1.val + l2.val + shift);
        if (sum >= 10) {
            result = new ListNode((sum - 10));
            shift = 1;
        } else {
            result = new ListNode((sum));
            shift = 0;
        }

        ListNode root = result;

        while (l1.next != null || l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            if (l1 == null) {
                l1 = new ListNode();
                l1.val = 0;
            }
            if (l2 == null) {
                l2 = new ListNode();
                l2.val = 0;
            }
            sum = (l1.val + l2.val + shift);
            if (sum >= 10) {
                result.next = new ListNode((sum - 10));
                shift = 1;
            } else {
                result.next = new ListNode(sum);
                shift = 0;
            }
            result = result.next;
        }

        if (shift == 1) {
            result.next = new ListNode(shift);
        }

        // return root;
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }
}