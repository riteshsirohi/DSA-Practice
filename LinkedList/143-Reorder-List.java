import java.util.Stack;

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        Stack<ListNode> st = new Stack<>();
        ListNode current = head;

        while (current != null) {
            st.push(current);
            current = current.next;
        }

        int size = st.size() / 2;
        current = head;

        while (size > 0) {
            ListNode last = st.pop();
            ListNode temp = current.next;
            current.next = last;
            last.next = temp;
            current = temp;
            size--;
        }
        if (current != null) {
            current.next = null;
        }
    }
}
