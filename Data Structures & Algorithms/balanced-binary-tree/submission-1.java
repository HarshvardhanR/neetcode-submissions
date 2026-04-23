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
    boolean answer = true;
    public boolean isBalanced(TreeNode root) {
        helper(root);
        return answer;
    }

    public int helper(TreeNode root){
        if(root==null) return 0;
        int leftH = helper(root.left);
        int rightH = helper(root.right);
        if(Math.abs(leftH - rightH) > 1) answer = false;
        return 1 + Math.max(leftH, rightH);
    }
}
