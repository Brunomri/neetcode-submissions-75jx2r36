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
    /* Optimal solution in O(n) time and O(1) space */
    public ListNode reverseList(ListNode head) {

        /* Keep track of the previous and current nodes
        starting at the head (head has no previous node) */
        ListNode previous = null;
        ListNode current = head;

        while(current != null) {
            /* To be able to proceed the list traversal, keep track of the next node 
            before making the next pointer of the current node point to the previous node */
            ListNode next = current.next;
            current.next = previous;
            /* Move both the previous and the current pointers to the next nodes */
            previous = current;
            current = next;
        }

        /* In the end, the previous node is the head of the reversed list (current will be null) */
        return previous;
    }
}
