// Source : https://leetcode.com/problems/merge-two-sorted-lists
// Author : zhaohaiyuan
// Date   : 2017-12-08

/*
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 */

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            ListNode mergedOne = new ListNode(-999999);
            ListNode stepNode = mergedOne;
            while (l1 != null && l2 != null) {
                ListNode newOne;
                if (l1.val <= l2.val) {
                    newOne = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    newOne = new ListNode(l2.val);
                    l2 = l2.next;
                }
                stepNode.next = newOne;
                stepNode = stepNode.next;
            }
            if (l1 != null) {
                stepNode.next = l1;
            }
            if (l2 != null) {
                stepNode.next = l2;
            }
            return mergedOne.next;

        }

    }
}
