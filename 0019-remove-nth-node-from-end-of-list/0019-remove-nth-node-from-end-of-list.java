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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next== null){
            return null;
        }
        int size = 0;
        ListNode curr =  head;
        while(curr != null){
            curr = curr.next;
            size++;
        }
            if(n == size){
                return head.next;
            }
        int IndexToSearch = size - n-1;
        ListNode prev = head;
        int i = 0;
        while(i < IndexToSearch){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return head;
    }
}