// Source : https://leetcode.com/problems/rotate-list
// Author : zhaohaiyuan
// Date   : 2017-12-11

/*
 * analysis:
 * if size >> k: 
 *     1) we better use two pointers, first and second, and first is always k node ahead of second
 *     2) we don't need count the list size
 * if size < k:
 *     1) when first reaches the end, it has to go to beginning of the list and go on,
 *     2) though no need for count the list size, movement may cost a lot
 *     3) actually we only need move k%n steps
 *
 * Solution: take acount two factors as followed.
 *     1) avoid useless movement cost
 *     2) uncertainty of which is larger between list size and k
 * the final algorithm: 1) compute the list size: n 2) rotate k%n
 *  
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if ((head == null || head.next == null) || k == 0) {
            return head;
        }
        int size = 1;
        ListNode first = head;
        while (first.next != null) {
            first = first.next;
            size++;
        }
        int realK = k % size;
        if (realK == 0) {
            return head;
        }
        int forwardStep = size - realK - 1;
        ListNode splitNode = head;
        while (forwardStep > 0) {
            splitNode = splitNode.next;
            forwardStep--;
        }
        first.next = head;
        ListNode newHead = splitNode.next;
        splitNode.next = null;
        return newHead;
    }
}
