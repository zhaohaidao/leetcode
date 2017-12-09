// Source : https://leetcode.com/problems/binary-tree-level-order-traversal
// Author : zhaohaiyuan
// Date   : 2017-12-09

/*
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 *                 [
 *                   [3],
 *                   [9,20],
 *                   [15,7]
 *                 ]
 *
 * Solution: levelTraverse
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderResults=new ArrayList<List<Integer>>();
        if (root == null) {
            return levelOrderResults;
        }
        Map<Integer, List<Integer>> levelTreeNodes = new TreeMap<Integer, List<Integer>>();
        levelTraverse(root, levelTreeNodes, 0);
        for (List<Integer> treeNodes : levelTreeNodes.values()) {
            levelOrderResults.add(treeNodes);
        }
        return levelOrderResults;
    }

    public void levelTraverse(TreeNode node, Map<Integer, List<Integer>> levelTreeNodes, int level) {
        if (node == null) {
            return;
        }
        List<Integer> treeNodes=levelTreeNodes.get(level);
        if (treeNodes==null) {
            treeNodes=new ArrayList<Integer>();
            levelTreeNodes.put(level, treeNodes);
        }
        treeNodes.add(node.val);
        int nextLevel=level+1;
        if (node.left!=null) {
            levelTraverse(node.left, levelTreeNodes, nextLevel);
        }
        if (node.right!=null) {
            levelTraverse(node.right, levelTreeNodes, nextLevel);
        }
    }
}
