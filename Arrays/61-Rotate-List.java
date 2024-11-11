/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode find(ListNode head, int n){
        int cnt = 1;
        ListNode temp = head;
        while(cnt!=n){
            temp = temp.next;
            cnt++;
        }
        return temp;
    }
    public ListNode rotateRight(ListNode head, int k) {
         if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode tail = head;
        int len = 1;

        while (tail.next!= null) {
            tail = tail.next;
            len++;
        }
         k = k % len;
        if (k == 0) {
            return head; 
        }
        tail.next = head;
        ListNode newLNode = find(head,len-k);

        head = newLNode.next;
        newLNode.next = null;


      return head;
    }
}