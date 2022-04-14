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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null) return head;
        ListNode temp = head;
        int c = 0;
        while(temp!=null){
            temp=temp.next;
            c++;
        }
        ListNode ans = null;
        ListNode tail = ans;
        temp = head;
        for(int i=1;i<=c-c%k;i+=k){
            
            ListNode sub = null;
            ListNode subTail = null;
            
            for(int j=1;j<=k;j++){
                
                sub = addAtFirst(sub,temp.val);
                temp=temp.next;
                
            }
            subTail = sub;
            while(subTail.next!=null){
                subTail=subTail.next;
            }
            // display(sub);
            // System.out.println(subTail.val);
            
            if(ans == null){
                ans = sub;
                tail = subTail;
            }
            else{
                tail = Tail(ans);
                tail.next = sub;
                tail=subTail;
            }
        }
        
        while(temp!=null){
            ans = addAtLast(ans,tail,temp.val);
            tail=tail.next;
            temp=temp.next;
        }
        
        return ans;
    }
    
    public ListNode addAtFirst(ListNode head, int val){
        ListNode temp = new ListNode();
        temp.val = val;
        temp.next = head;
        head = temp;
        return head;
    }
    public ListNode addAtLast(ListNode ans, ListNode tail, int val){
        ListNode temp = new ListNode();
        temp.val = val;
        tail.next = temp;
        return ans;
    }
    public ListNode Tail(ListNode ans){
        ListNode temp = ans;
        while(temp.next!=null){
            temp=temp.next;
        }
        return temp;
    }
    // public void display(ListNode head){
    //     while(head!=null){
    //         System.out.print(head.val+" ");
    //         head = head.next;
    //     }
    //     System.out.println();
    // }
    
}