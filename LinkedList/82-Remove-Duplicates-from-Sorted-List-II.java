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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prevNode = new ListNode(0);
\t\tif (head == null || head.next == null) {
\t\t\treturn head;
\t\t}
\t\tListNode currentNode = head;
\t\thead = prevNode;
\t\twhile (currentNode != null && currentNode.next != null) {
\t\t\tif(currentNode.next != null && currentNode.next.val == currentNode.val){
\t\t\t\twhile(currentNode.next != null && currentNode.next.val == currentNode.val){
\t\t\t\t\t\tcurrentNode = currentNode.next;
\t\t\t\t}
\t\t\t\tprevNode.next = currentNode.next;
\t\t\t} else {
\t\t\t\tprevNode.next = currentNode;
\t\t\t\tprevNode = prevNode.next;
\t\t\t}
\t\t\tcurrentNode = currentNode.next;
\t\t}
\t\treturn head.next;
    }
}