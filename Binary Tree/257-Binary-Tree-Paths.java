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
    private void traverse(TreeNode root, String path, List<String> ans){
        if(root==null){
            return;
        }
       path += Integer.toString(root.val);

       if(root.left==null && root.right==null){
        ans.add(path);
       }else{
        path += "->";
        traverse(root.left,path,ans);
        traverse(root.right,path,ans); 
       } 
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();

       if(root!=null)
        traverse(root,"",ans);
    
       return ans;

    }
}