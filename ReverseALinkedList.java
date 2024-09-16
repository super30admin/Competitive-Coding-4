/* 
Iterative Solution

Time: O(N), where N is number of nodes in linked list 
Space: O(1)
Passed All Test Cases 
*/ 

class Solution {
    public ListNode reverseList(ListNode head) {
        //edge cases 
        if (head == null || head.next == null) return head ; 
        
        ListNode prev = null ; 
        ListNode curo = head ; 
        ListNode temp = head ; 
        
        while (curo != null) {
            temp = curo.next ; 
            curo.next = prev ; 
            prev = curo ; 
            curo = temp ; 
        }
        
        return prev ; 
        
    }
}



/*
Recursive Solution 
Time: O(N), where N is # of nodes in linked list 
Space: O(N), the  implicit recursion call stack 
Passed All Test Cases 
*/


class Solution {
    public ListNode reverseList(ListNode head) {
        //base case 
        if(head == null || head.next == null)
            return head ;

        //recursvie case 
        ListNode tailHead = reverseList(head.next) ; 
        head.next.next = head ; 
        head.next = null ; 
        return tailHead ; 
    }
}

