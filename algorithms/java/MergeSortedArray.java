// Source : https://leetcode.com/problems/merge-sorted-array
// Author : zhaohaiyuan
// Date   : 2017-12-08

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 *
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 && n == 0) {
            return;
        } else if (n == 0) {
            return;
        } else if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        } else {
            int index1 = m - 1;
            int index2 = n - 1;
            int end1 = m - 1;
            while (index1 >= 0 && index2 >= 0) {
                if (nums2[index2] >= nums1[index1]) {
                    rightShift(nums1, index1 + 1, end1, 1);
                    end1++;
                    nums1[index1 + 1] = nums2[index2];
                    index2--;
                } else {
                    index1--;
                }
            }
            if (index2 >= 0) {
                rightShift(nums1, 0, end1, index2 + 1);
                for (int i = 0; i <= index2; i++) {
                    nums1[i] = nums2[i];
                }
            }
            return;

        }

    }

    void rightShift(int[] nums1, int from, int to, int step) {
        for (int i = to; i >= from; i--) {
            nums1[i + step] = nums1[i];
        }
    }
}
