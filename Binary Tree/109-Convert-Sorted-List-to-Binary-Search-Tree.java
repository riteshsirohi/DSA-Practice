/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    private ListNode Current;
    private int count(ListNode head){
        int cnt = 0;
        while(head!=null){
            cnt++;
            head = head.next;
        }
        return cnt;
    }
    public TreeNode sortedListToBST(ListNode head) {
        Current = head;
        int cnt = count(head);
          return helper(cnt);
    }
    private TreeNode helper(int n){
        if(n<=0){
            return null;
        }
        TreeNode left = helper(n/2);

        TreeNode root = new TreeNode(Current.val);
        Current = Current.next;

        TreeNode right = helper(n-n/2-1);

        root.left = left;
        root.right = right;

        return root;
        
    }
}