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
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode Current=head;
        ListNode previous=null;
        ListNode Next=null;
        while(Current!=null){
            Next=Current.next;
            Current.next=previous;
            previous=Current;
            Current=Next;

        }
        return previous;
    }
}