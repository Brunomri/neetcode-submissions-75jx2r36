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
    /* Time and space complexity of this solution is O(n + m),
    where n is the length of list1 and m is the length of list2 */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode node = result;

        /* While both lists still have nodes to iterate over, compare all of them
        and merge to the result list */
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }

        /* In the end, if any node remains in list1, link them to the result list */
        if(list1 != null) {
            node.next = list1;
        }

        /* In the end, if any node remains in list2, link them to the result list */
        if(list2 != null) {
            node.next = list2;
        }

        /* Return next because the first node in the result is a dummy */
        return result.next;
    }
}