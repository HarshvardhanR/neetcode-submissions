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

    public int HeightReturner(TreeNode root, ArrayList<Integer> a1){
        if(root==null){
            return 0;
        }
        int leftHeight = HeightReturner(root.left, a1);
        int rightHeight = HeightReturner(root.right, a1);
        a1.add(0, leftHeight);
        a1.add(0, rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        ArrayList<Integer> a1 = new ArrayList<>();
        HeightReturner(root, a1);
        int i=0;
        while(i<a1.size()){
            if(a1.get(i) - a1.get(i+1)!=0 && Math.abs(a1.get(i) - a1.get(i+1))!=1){
                return false;
            }
            i+=2;
        }
        return true;
    }
}
