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
class Solution {
     private ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        head = reverse(head);
      
      if(n==1){
        return reverse(head.next);
      }

        ListNode curr = head;
        ListNode prev = null;
        for(int i=1;i<n;i++){
            prev = curr;
            curr = curr.next;
        }
         prev.next = curr.next;
         
        return reverse(head);
    }
}