// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return false;
        ListNode temp = head;
        int count=0;
        while(temp != null){
            count ++;
            temp= temp.next;
        }
        int mid = count /2;
        // reverse later half of the LL
        temp = head;
        for(int i=0; i<mid; i++){
            temp = temp.next; 
        } // we'll come to mid
        
        // reverse later half
        ListNode prev = null;
        ListNode curr = temp;
        ListNode fast = temp.next;
        while(fast != null){
            // System.out.println(curr.val);
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = curr.next;
        }
        curr.next = prev;
        temp = curr;
        // use reversed LL to check if elements are equal
        while(temp != null && head != null){
            System.out.println(head.val);
            System.out.println(temp.val);
            if(temp.val != head.val) return false;
            temp = temp.next; 
            head= head.next;
        }
        return true;
        
    }
       
}