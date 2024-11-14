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
    private ListNode reverse(ListNode head, int k) {
        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;
        int count = 0;

        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        head.next = curr; 
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode curr = head;
        
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (len >= k) {
            prevGroupEnd.next = reverse(prevGroupEnd.next, k);
            for (int i = 0; i < k; i++) {
                prevGroupEnd = prevGroupEnd.next;
            }
            len -= k;
        }
        
        return dummy.next;
    }
}
