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
    /* Recursive solution in O(n) time and O(n) space */
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;

        ListNode newHead = head;
        if(head.next != null) {
            newHead = reverseList(head.next);
            /* Reverse the link between the next node and the head */
            head.next.next = head;
        }
        /* Undo the original link from the head to the next node */
        head.next = null;
        
        return newHead;
    }
}
