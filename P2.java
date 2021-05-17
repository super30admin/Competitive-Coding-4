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
//time- o(n)
//space-o(1)
//passed in leetcode-yes
class Solution {
    public boolean isPalindrome(ListNode head) {
         if (head == null) return true;

        ListNode walker = head;
        ListNode runner = head;
        
        while(runner.next !=null && runner.next.next !=null )
        {
            walker=walker.next;
            runner=runner.next.next;
        }
        ListNode walker_new= reverse(walker.next);//beginning of second half
        walker.next = null; //making the first half end with null
        runner = head; //reassigning runner to head, for first halfto check palindrome, 
        while(walker_new != null && runner!=null )
        {
            if(runner.val != walker_new.val)
            {
                return false;
            }
            runner=runner.next;
            walker_new=walker_new.next;
        }
        
        return true;
    }
    
    public ListNode reverse(ListNode curr)
    {
        ListNode prev=null;
        
        while(curr!=null)
        {
            ListNode temp= curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
        
    }
}