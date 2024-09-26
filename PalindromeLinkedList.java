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

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes


// Your code here along with comments explaining your approach
/*Approach
1) two pointers slow and head
2) find mid
3) create another list l2 by assigning l2 =slow.next
4) reverse the list l2
5) now traverse both the lists l1 and l2 and check for elements
6) if values are equal then continue else just return 


*/

class Solution {
    public boolean isPalindrome(ListNode head) {
        
        
        if(head==null)
        {
            return true;
        }
        ListNode slow =head;
        ListNode fast = head.next;
        
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode l2 = slow.next;
        slow.next =null;
        
        ListNode l1 =head;
        
        ListNode head2=null;
        head2=reverseList(l2);
        
        
        while(l1!=null && head2!=null)
        {
            if(l1.val!=head2.val)
            {
                return false;
            }
            l1=l1.next;
            head2=head2.next;
            
            
        }
        
        return true;
        
    }
    
    public ListNode reverseList(ListNode l2)
    {
        ListNode prev =null;
       
       while(l2!=null)
       {
           ListNode nextNode = l2.next;
           l2.next=prev;
           prev =l2;
           l2 =nextNode;
       }
        
       return prev; 
    }
}