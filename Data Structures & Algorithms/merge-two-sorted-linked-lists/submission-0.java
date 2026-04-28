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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = null;
        ListNode head = null;
        ListNode next = null;

        while(true) {

            if(list1 == null && list2 == null) break;

            if(list1 == null) {
                next = list2;
                list2 = list2.next;
            }

            else if(list2 == null) {
                next = list1;
                list1 = list1.next;
            }

            else {
                if(list1.val <= list2.val) {
                    next = list1;
                    list1 = list1.next;
                } else {
                    next = list2;
                    list2 = list2.next;
                }
            }

            if(result == null) {
                result = new ListNode(next.val);
                head = result;
            } else {
                result.next = next;
                result = result.next;
            } 
        }         

        return head;
    }
}