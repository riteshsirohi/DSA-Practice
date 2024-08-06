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
     void printLeftView(TreeNode root,List<Integer> list,int level){
          if(root==null){
              return;
          }
          if(list.size()==level){
              list.add(root.val);
          }
          printLeftView(root.right,list,level+1);
          printLeftView(root.left,list,level+1);
      }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        printLeftView(root,list,0);

        return list;
    }
}