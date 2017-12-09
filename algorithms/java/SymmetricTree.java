// Source : https://leetcode.com/problems/symmetric-tree
// Author : zhaohaiyuan
// Date   : 2017-12-09

/*
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root==null) {
            return true;
        }
        return root==null ? true : isSymmetricHelper(root.left, root.right);
    }

    public boolean isSymmetricHelper(TreeNode node, TreeNode mirrorNode) {
        if (node == null && mirrorNode==null) {
            return true;
        } else if ((node == null) != (mirrorNode==null)) {
            return false;
        } else {
            if (node.val != mirrorNode.val) {
                return false;
            } else {
                return isSymmetricHelper(node.left, mirrorNode.right) && isSymmetricHelper(node.right, mirrorNode.left);
            }
        }
    }
}
