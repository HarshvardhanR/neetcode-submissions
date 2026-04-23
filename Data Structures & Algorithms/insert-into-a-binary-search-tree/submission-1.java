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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return helper(root, val);
    }

    public TreeNode helper(TreeNode temp, int val){
        TreeNode root = temp;
        TreeNode newNode = new TreeNode(val);
        if(temp==null){
            root=newNode;
            return root;
        }
        while(root!=null){
            if(val > root.val){
                if(root.right==null){
                    root.right = newNode;
                    break;
                }
                root = root.right;
            }
            else{
                if(root.left==null){
                    root.left = newNode;
                    break;
                }
                root = root.left;
            }
        }

        return temp;
    }
}