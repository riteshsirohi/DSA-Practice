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
    private int Height(TreeNode root){
        if (root==null){
            return 0;
        }
        int left=Height(root.left);
        int right=Height(root.right);

        return 1+ Math.max(left,right);
        }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int lh = diameterOfBinaryTree(root.left);
        int rh = diameterOfBinaryTree(root.right);
        int total = Height(root.left)+Height(root.right);

        return Math.max(lh,Math.max(rh,total));
    }
}