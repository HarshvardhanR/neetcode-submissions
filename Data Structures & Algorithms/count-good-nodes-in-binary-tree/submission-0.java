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
    int good = 0;
    public int goodNodes(TreeNode root) {
        int currMax = Integer.MIN_VALUE;
        helper(root, currMax);
        return good;
    }

    public void helper(TreeNode root, int currMax){
        if(root==null) return;
        if(root.val >= currMax){
            good++;
        }
        currMax = Math.max(currMax, root.val);
        helper(root.left, currMax);
        helper(root.right, currMax);
    }
}
