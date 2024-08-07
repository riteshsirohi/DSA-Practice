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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root,0));
        int maxwidth = 0;

        while(!q.isEmpty()){
            int size = q.size();
            int left = q.peek().getValue();
            int right = left;
            for(int i=0;i<size;i++){
                Pair<TreeNode,Integer> node = q.poll();
                TreeNode curr = node.getKey();
                int idx = node.getValue();
                right=idx;

                if(curr.left!=null){
                    q.offer(new Pair<>(curr.left,2*idx+1));
                }
                if(curr.right!=null){
                    q.offer(new Pair<>(curr.right,2*idx+2));
                }
                maxwidth = Math.max(maxwidth,right-left+1);
            }
        }
        return maxwidth;
    }
}