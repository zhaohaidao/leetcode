// Source : https://leetcode.com/problems/spiral-matrix
// Author : zhaohaiyuan
// Date   : 2017-12-08

/*
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * For example,
 * Given the following matrix:
 *
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *    You should return [1,2,3,6,9,8,7,4,5].
 *
 */

/*
 * Solution: traversal by clockwise order: top->right->down->left
 *
 */

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<Integer>();
        }
        int top = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        List<Integer> result = new ArrayList<Integer>();
        while (left <= right && top <= down) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= down) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[down][i]);
                }

            }
            down--;

            if (left <= right) {
                for (int i = down; i >= top; i--) {
                    result.add(matrix[i][left]);
                }

            }
            left++;
        }
        return result;
    }

}
