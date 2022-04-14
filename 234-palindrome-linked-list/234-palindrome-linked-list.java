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
    private boolean IsPalindromeHelper(ListNode right) {
      if (right == null) {
        return true;
      }

      boolean rres = IsPalindromeHelper(right.next);
      if (rres == false) {
        return false;
      } else if (right.val != pleft.val) {
        return false;
      }
      pleft = pleft.next;
      return true;
    }
    ListNode pleft;
    public boolean isPalindrome(ListNode head) {
        pleft = head;
      return IsPalindromeHelper(head);
    }
}