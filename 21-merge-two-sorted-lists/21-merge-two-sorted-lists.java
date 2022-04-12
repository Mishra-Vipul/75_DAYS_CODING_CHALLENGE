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
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode ans = null;
        ListNode tail = new ListNode();
    
        while(temp1!=null&&temp2!=null){
            ListNode temp3 = new ListNode();
            temp3.next = null;
            if(temp1.val<=temp2.val){
                temp3.val = temp1.val;
                temp1=temp1.next;
            }
            else{
                temp3.val = temp2.val;
                temp2=temp2.next;
            }
            if(ans==null){
                ans = temp3;
                tail = ans;
            }
            else{
                tail.next = temp3;
                tail=temp3;
            }
            
            
        }
        while(temp1!=null){
            ListNode temp3 = new ListNode();
            temp3.next = null;
            temp3.val = temp1.val;
            temp1=temp1.next;
            if(ans==null){
                ans = temp3;
                tail = ans;
            }
            else{
                tail.next = temp3;
                tail=temp3;
            }
        }
        while(temp2!=null){
            ListNode temp3 = new ListNode();
            temp3.next = null;
            temp3.val = temp2.val;
            temp2=temp2.next;
            if(ans==null){
                ans = temp3;
                tail = ans;
            }
            else{
                tail.next = temp3;
                tail=temp3;
            }
        }
        
        return ans;
    }
}