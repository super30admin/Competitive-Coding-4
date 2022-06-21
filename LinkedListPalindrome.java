//Time O(n)
// Space O(1)

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
    public boolean isPalindrome(ListNode head) {
        
        ListNode slow= head;
        ListNode fast= head;
        
        while(fast.next!=null && fast.next.next!=null)
        { 
            
            slow= slow.next;
            fast= fast.next.next;
        }
        
       ListNode h1= reverse(slow.next);
        slow.next= null;
        
        while(h1!=null && head!=null)
        { if(h1.val !=head.val)
            return false;
         h1=h1.next;
         head = head.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode head)
    { if(head==null || head.next==null)
        return head;
        ListNode prev= null;
        ListNode curr= head;
        ListNode next= head.next;
        while(next!=null)
        {
            curr.next= prev;
            prev= curr;
            curr= next;
            next= next.next;
        }
        curr.next= prev;
        return curr;
        
        
        
    }
    
}