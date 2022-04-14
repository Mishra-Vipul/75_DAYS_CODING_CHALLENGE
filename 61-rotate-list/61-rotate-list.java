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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        ListNode temp = head;
        int c=0;
        while(temp!=null){
            temp = temp.next;
            c++;
        }
        k=k%c;
        
        ListNode ans = null;
        ListNode temp2 = ans;
        temp = head;
        for(int i=0;i<c-k;i++){
            if(ans == null){
                ans = temp;
                temp2=temp;
            }
            else{
                temp2.next = temp;
                temp2 = temp;
            }
            temp = temp.next;
            temp2.next=null;
        }
        ListNode rev = null;
        temp2 = rev;
        for(int i=c-k;i<c;i++){
            if(rev == null){
                rev = temp;
                temp2=temp;
            }
            else{
                temp2.next = temp;
                temp2 = temp;
            }
            temp = temp.next;
        }
        
        // System.out.println(rev.val);
        // display(ans);
        ans = reverse(ans);
        rev = reverse(rev);
        // display(ans);
        temp = ans;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = rev;
        ans = reverse(ans);
        return ans;
    }
    
    public ListNode reverse(ListNode head){
        if(head==null||head.next == null) return head;
        ListNode temp=head;
        ListNode tnext = head.next;
        ListNode prev = null;
        while(tnext!=null){
            temp.next = prev;
            prev = temp;
            temp = tnext;
            tnext = tnext.next;
        }
        temp.next = prev;
        head = temp;
        return head;
    }
    
    public void display(ListNode head){
        ListNode temp = head;
        while(temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    
}