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
    int idx=0;
    private HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        for(int i=0;i<postorder.length;i++){
            map.put(postorder[i],i);
        }
       return helper(preorder,postorder,0,postorder.length-1);
    }
    private TreeNode helper(int[] preorder, int[] postorder, int left, int right){
        if(left>right || idx>=preorder.length){
            return null;
        }
        TreeNode root = new TreeNode(preorder[idx++]);

        if(left==right || idx>=preorder.length){
            return root;
        }
        int next = map.get(preorder[idx]);

        root.left = helper(preorder,postorder,left,next);
        root.right = helper(preorder,postorder,next+1,right-1);

        return root;
    }
}