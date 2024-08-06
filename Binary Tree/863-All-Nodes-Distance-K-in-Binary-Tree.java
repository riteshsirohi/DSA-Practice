/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
       List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        HashMap<TreeNode,TreeNode> Parentmap = new HashMap<>();
         findParent(Parentmap,root);
         Queue<TreeNode> q = new LinkedList<>();
         HashSet<TreeNode> visited = new HashSet<>();

         q.offer(target);

         while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                visited.add(curr);
                if(k==0){
                    ans.add(curr.val);
                }
                if(Parentmap.containsKey(curr) && !visited.contains(Parentmap.get(curr))){
                    q.add(Parentmap.get(curr));
                }
                if(curr.left!=null && !visited.contains(curr.left)){
                    q.add(curr.left);
                }
                if(curr.right!=null && !visited.contains(curr.right)){
                    q.add(curr.right);
                }
            }
            k--;
            if(k<0) break;
         }
         return ans;
    }
    private void findParent( HashMap<TreeNode,TreeNode> Parentmap, TreeNode root){
        if(root==null)return;
        if(root.left!=null){
            Parentmap.put(root.left,root);
        }
        if(root.right!=null){
            Parentmap.put(root.right,root);
        }
        findParent(Parentmap,root.left);
        findParent(Parentmap,root.right);
        return;
    }
}