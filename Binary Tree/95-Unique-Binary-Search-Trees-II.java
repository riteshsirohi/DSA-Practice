/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    Map<Pair<Integer, Integer>, List<TreeNode>> map;

    private List<TreeNode> solve(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        if(map.containsKey(new Pair<>(start,end))){
            return map.get(new Pair<>(start,end));
        }


        for (int i = start; i <= end; i++) {
            List<TreeNode> leftsub = solve(start, i - 1);
            List<TreeNode> rightsub = solve(i + 1, end);

            for (TreeNode left : leftsub) {
                for (TreeNode right : rightsub) {
                    TreeNode root = new TreeNode(i,left,right);
                    res.add(root);
                }
            }
        }
        map.put(new Pair<>(start,end),res);
        return res;
    }

    public List<TreeNode> generateTrees(int n) {
       map = new HashMap<>();
        return solve(1, n);
    }
}