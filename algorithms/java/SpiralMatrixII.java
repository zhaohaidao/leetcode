// Source : https://leetcode.com/problems/spiral-matrix-ii
// Author : zhaohaiyuan
// Date   : 2017-12-08

/*
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * For example,
 * Given n = 3,
 *
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 */

/*
 * Solution: assign number++ to matrix by clockwise order: top->right->down->left
 */
class Solution {
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][0];
        }
        int[][] matrix = new int[n][n];
        if (n == 1) {
            matrix[0][0] = n;
            return matrix;
        }
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int number = 1;
        while (number <= n * n && left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = number++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = number++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = number++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = number++;
            }
            left++;

        }
        return matrix;
    }
}
