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
        
        ListNode temp = head;
        int size=0;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        n = size-n;
        if(n==0) {
            head = head.next;
            return head;
        }
        temp = head;
        ListNode prev = null;
        for(int i=0;i<n;i++){
            prev=temp;
            temp = temp.next;
        }
        prev.next = temp.next;
        temp.next = null;
        return head;
    }
}