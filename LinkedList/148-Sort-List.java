
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
    public ListNode sortList(ListNode head) {
        List<Integer> values = new ArrayList<>();

        // Extract values from the linked list and store them in an ArrayList
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

        // Sort the ArrayList
        Collections.sort(values);

        // Create a new sorted linked list from the sorted ArrayList
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }
}
