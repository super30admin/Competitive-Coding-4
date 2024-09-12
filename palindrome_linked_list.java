// Time Complexity : ~O(n) for both approaches
// Space Complexity : O(n) for 1st approach, O(1) for second approach
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
---------------------------------------------------------------------------Approach 1 ---------------------------------------------------------------------------
class Solution {
    public boolean isPalindrome(ListNode head) {
    //Taking two pointers pointing to head
    ListNode curr = head;
    ListNode curr2 = head;
    
    //We will be using stack for both inserting elements and comparing while popping from the stack.
    Stack<Integer> stack = new Stack<>();
    
    //Pushing into the stack
    while(curr!=null){
        stack.push(curr.val);
        curr = curr.next;
    }
    
      //At any point, if value popped is not equal to element from start/head of linked list, we return false
    while(curr2!=null){
        if(curr2.val!=stack.pop()){
            return false;
            //break;
        }
        curr2 = curr2.next;
    }
    
    return true;
  }
}

---------------------------------------------------------------- Approach 2----------------------------------------------------------------
  // This involves finding the mid point first and then reveresing the second part after mid. Finally we compare reversed second half with first half.
  class Solution {
    public boolean isPalindrome(ListNode head) {
        //Using mid and reverse approach
        if(head==null || head.next==null) return true;
        ListNode mid = mid(head);//store mid of linked list in mid
        ListNode newHead = mid.next;
        mid.next=null;//removing the connection from first half and second half
        
        ListNode first = head;
        ListNode second = reverse(newHead);//reversing the second part, code below
        
        //At any point, if element from second half of linked list is not equal to first part, we return false
        while(second!=null){
            if(first.val!=second.val){
                return false;
                //break;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }
    
    //Code for reversing the second half of linked list
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        
        ListNode prev = null;
        ListNode next;
        ListNode curr = head;
        
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    //Code for finding the mid of linkedlist - two pointers approach
    public ListNode mid(ListNode head){
        if(head==null || head.next==null) return head;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
}
