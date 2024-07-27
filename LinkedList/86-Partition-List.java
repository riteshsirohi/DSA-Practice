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
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);

        ListNode smallp = small;
        ListNode largep = large;

        while(head!=null){
            if(head.val<x){
                smallp.next=head;
                smallp=smallp.next;
            }else{
                largep.next=head;
                largep=largep.next;
            }
            head=head.next;
        }
        smallp.next=large.next;
        largep.next=null;
        return small.next;
    }
}