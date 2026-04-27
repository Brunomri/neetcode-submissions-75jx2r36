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
        if(head == null) return null;
        if(head.next == null) return head;

        List<ListNode> nodes = new ArrayList<>();
        while(head != null) {
            nodes.add(head);
            head = head.next;
        }

        for(int i = nodes.size() - 1; i > 0; i--) {
            ListNode current = nodes.get(i);
            current.next = nodes.get(i - 1);
        }
        nodes.get(0).next = null;

        return nodes.get(nodes.size() - 1);
    }
}
