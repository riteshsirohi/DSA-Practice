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
    int cam=0;
    public int minCameraCover(TreeNode root) {
       int ans =  helper(root);
       return ans==0? cam+1 : cam;
    }
    private int helper(TreeNode root){
       if(root==null) return 1;
       int left = helper(root.left);
       int right = helper(root.right);

       if(left==0 || right==0){
          cam++;
          return 2;
       }else if(left==2 || right==2){
        return 1;
       }else{
        return 0;
       }
    }
}