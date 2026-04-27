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
    /* Brute force solution in O(n) time and O(n) space */
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;

        /* Add all the linked list nodes to an ArrayList*/
        List<ListNode> nodes = new ArrayList<>();
        while(head != null) {
            nodes.add(head);
            head = head.next;
        }

        /* Backward iterate over the nodes in the ArrayList, updating the
        next pointer of the current node to the previous node, this will
        reverse the original linked list */
        for(int i = nodes.size() - 1; i > 0; i--) {
            ListNode current = nodes.get(i);
            current.next = nodes.get(i - 1);
        }
        /* The first node in the ArrayList is in fact the tail of the
        reversed linked list, it has no next element */
        nodes.get(0).next = null;

        /* Return the head of the reversed linked list */
        return nodes.get(nodes.size() - 1);
    }
}
