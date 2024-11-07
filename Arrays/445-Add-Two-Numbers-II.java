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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       l1 =  reverse(l1);
       l2 = reverse(l2);

       ListNode dummy = new ListNode(-1);
       ListNode tail = dummy;
       int carry = 0;

       while(l1!=null || l2!=null){
        int x = (l1!=null)? l1.val : 0;
        int y = (l2!=null)? l2.val : 0;
        int sum = x+y+carry;

        carry = sum/10;
        tail.next = new ListNode(sum%10);
        tail = tail.next;

        if(l1!=null) l1 = l1.next;
        if(l2!=null) l2 = l2.next;
       }
       if(carry>0){
        tail.next = new ListNode(carry);
       }
       return reverse(dummy.next);
    }
}