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
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1!=null) ? l1 : l2;

        return dummy.next;
    }
    private ListNode partition(int start, int end, ListNode[] lists){
        if(start>end){
            return null; 
        }
        if(start==end){
            return lists[start];
        }
        int mid = start+(end-start)/2;
        ListNode l1 = partition(start,mid,lists);
        ListNode l2 = partition(mid+1,end,lists);

        return merge(l1,l2);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;

        if(k==0) return null;

        return partition(0,k-1,lists);
    }
}