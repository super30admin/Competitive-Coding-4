// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach: Reverse the linked list from the middle and traverse with two heads
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
    
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!= null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = slow.next;
        slow = null;
        ListNode n;
        
        while(fast!=null){
            n = fast.next;
            fast.next = slow;
            slow = fast;
            fast = n;  
        }
        ListNode head2 = slow;
        
        
        
        slow = head;
        fast = head2;
        
        while(fast!=null){
            if(slow.val != fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next; 
        }
        
        return true;
            
    }

public static void main(String args[]){

        Solution solution = new Solution();
        ListNode head = new ListNode();
        head.val = 1;
        System.out.println(solution.isPalindrome(head));
        
}

}

 