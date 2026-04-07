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
    public int rob(TreeNode root) {
        //Set<TreeNode> robbed = new HashSet<>();
        //Set<TreeNode> visited = new HashSet<>();
        int[] values = dfs(root);
        return Math.max(values[0], values[1]);
    }

    private int[] dfs(TreeNode root) {
        int[] values = new int[2];
        if (root == null) return values;

        int[] leftSubtree = dfs(root.left);
        int[] rightSubtree = dfs(root.right);

        return calculateValues(root, leftSubtree, rightSubtree);
    }

    private int[] calculateValues(TreeNode root, int[] leftSubtree, int[] rightSubtree) {
        int[] values = new int[2];

        int withRoot = root.val + leftSubtree[1] + rightSubtree[1];
        int withoutRoot = Math.max(leftSubtree[0], leftSubtree[1]) + Math.max(rightSubtree[0], rightSubtree[1]);

        values[0] = withRoot;
        values[1] = withoutRoot;
        return values;
    }
}