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
        static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head;
        while(next!=null){
            next = next.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    static ListNode insertAtTail(int val , ListNode head){
         
        ListNode temp = new ListNode();
        temp.val = val;
        temp.next=null;
        if(head == null){
            head = temp;
            head.next=null;
        }
        else{
            ListNode temp2 = head;
            while(temp2.next!=null){
                temp2=temp2.next;
            }
            temp2.next=temp;
            temp2=temp;
            temp2.next=null;
        }
        
        return head;
        
    }
    
    
    static ListNode add(ListNode head1, ListNode head2){
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        ListNode anshead = null;
        int carry = 0;
        
        int f=1;
        
        while(temp1!=null || temp2 != null || carry!=0){
             
            int sum = ((temp1!=null?temp1.val:0) + (temp2!=null?temp2.val:0)) + carry;
            int rem = sum%10;
            carry = sum/10;
            
        
            anshead = insertAtTail(rem , anshead);
            if(temp1!=null)temp1 = temp1.next;
            if(temp2!=null)temp2 = temp2.next;
        }
        return anshead;
    }
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Write your code here.
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        ListNode ans = add(l1,l2);
        ans = reverse(ans);
        return ans;
        }
    
}