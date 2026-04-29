/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return dfs(root, 1);
    }

    private int dfs(TreeNode node, int maxDepth) {
        /* Null nodes don't contribute to the tree depth */
        if(node == null) return 0;

        /* For a given node, its maximum depth is the maximum depth between the left and right
        subtrees, plus the node itself */
        maxDepth = Math.max(dfs(node.left, maxDepth), dfs(node.right, maxDepth));
        return ++maxDepth;
    }
}
