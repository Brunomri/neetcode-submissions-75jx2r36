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
    /* Main strategy is, for each node, decide to include or not its root depending on the max value of its subtrees. */
    public int rob(TreeNode root) {
        int[] values = dfs(root);
        return Math.max(values[0], values[1]);
    }

    /* Use DFS to implement a post-order traversal that recursively calculates the max value of each subtree */
    private int[] dfs(TreeNode root) {
        /* The result is a 2-element array, where the first element is the max value including the root
        and the second element is the max value excluding the root */
        int[] values = new int[2];
        // Leaf receive max value of 0 for both cases
        if (root == null) return values;

        int[] leftSubtree = dfs(root.left);
        int[] rightSubtree = dfs(root.right);

        /* After the max values for both left and right subtrees are available,
        we decide to include or not the root for the current node max value */
        return calculateValues(root, leftSubtree, rightSubtree);
    }

    private int[] calculateValues(TreeNode root, int[] leftSubtree, int[] rightSubtree) {
        int[] values = new int[2];

        /* When including the current node, we must use the max values that excludes the root of the left and right subtrees,
        otherwise this would mean robbing two adjacent houses (max values exlcuding the root have index 1 in the result array) */
        int withRoot = root.val + leftSubtree[1] + rightSubtree[1];
        /* When exclusing the current node, we sum the max value of the left subtree and the max value of the right subtree,
        since the current node is not selected, we can pick whatever case maximises the result, because there won't be two adjacent houses being robbed */
        int withoutRoot = Math.max(leftSubtree[0], leftSubtree[1]) + Math.max(rightSubtree[0], rightSubtree[1]);

        values[0] = withRoot;
        values[1] = withoutRoot;
        return values;
    }
}