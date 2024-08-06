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
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long,Integer> map = new HashMap<>();

        map.put(0L,1);
        return DFS(root,targetSum, 0, map);
    }
     int DFS(TreeNode node, int target, long currentsum, HashMap<Long,Integer> map){
        if(node==null){
            return 0;
        }
        currentsum+=node.val;

        int res = map.getOrDefault(currentsum-target,0);

        map.put(currentsum, map.getOrDefault(currentsum,0)+1);

        res+=DFS(node.left,target,currentsum,map);
        res+=DFS(node.right,target,currentsum, map);

        map.put(currentsum, map.get(currentsum)-1);
          
          return res;
    }
}