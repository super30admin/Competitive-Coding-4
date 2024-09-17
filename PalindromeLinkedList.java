// Time Complexity : O(number of nodes of linked list)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

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
    ListNode tmp;
    public boolean helper(ListNode head) {
        if(head==null)
            return true;
        if(!helper(head.next))
            return false;
        int tmpVal = tmp.val;
        tmp=tmp.next;
        return tmpVal==head.val;

        }
    
    public boolean isPalindrome(ListNode head) {
        tmp=head;
        return helper(head);
    }
    
    
}

// Time Complexity : O(number of nodes of linked list)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

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
    public ListNode reverseLinkedList(ListNode head){
        ListNode tmp = head,prev=null;
        while(tmp!=null){
            ListNode next = tmp.next;
            tmp.next=prev;
            prev=tmp;
            tmp=next;
        }
        
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null)
            return true;
        ListNode fast=head,slow=head,tmpStart = null;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        
        // if(fast!=null)
        //     slow=slow.next;

        ListNode tmpEnd = reverseLinkedList(slow);
        tmpStart = head;
        
        while(tmpStart!=null && tmpEnd!=null){
            
            if(tmpStart.val != tmpEnd.val)
                return false;
            tmpStart =tmpStart.next;
            tmpEnd = tmpEnd.next;
        }
        
        return true;
    }
    
}