// Source : https://leetcode.com/problems/sort-list
// Author : zhaohaiyuan
// Date   : 2017-12-09

/*
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Solution: 
 *	1) O(nlogn) => merge sort
 *	2) how to find middle node quickly: node1 and node2, node1 go forward one step when node2 go forward two step
 *
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode splitNode = head;
        ListNode trackEndNode = head;
        while (trackEndNode.next != null && trackEndNode.next.next != null) {
            splitNode = splitNode.next;
            trackEndNode = trackEndNode.next.next;
        }
        ListNode l1 = head;
        ListNode l2 = splitNode.next;
        splitNode.next = null;
        ListNode sortedL1 = sortList(l1);
        ListNode sortedL2 = sortList(l2);
        return mergeTwoLists(sortedL1, sortedL2);
    }

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
                    ListNode tmp = l1.next;
                    newOne = l1;
                    l1 = tmp;
                } else {
                    ListNode tmp = l2.next;
                    newOne = l2;
                    l2 = tmp;
                }
                newOne.next = null;
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
