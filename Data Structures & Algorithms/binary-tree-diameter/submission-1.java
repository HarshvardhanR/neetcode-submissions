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
    int maxD = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return maxD;
    }

    public int helper(TreeNode root){
        if(root == null) return 0;
        int leftH = helper(root.left);
        int rightH = helper(root.right);
        maxD = Math.max(maxD, leftH + rightH);
        return 1 + Math.max(leftH, rightH);
    }
}
