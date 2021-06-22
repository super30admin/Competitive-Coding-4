/* Approach 1 TC - O (2n),since a two pass solution SC O(1)*/

class Solution {
    public boolean isPalindrome(ListNode head) {
        // approach - 1 reverse second half and check if the nodes match to its first half
        // approach 2 - ceonvert to array and reverse the array and check if the reversed array is same asorogianl array
        // approach 3 - reverse the linked list and comare the two lists\
       
        // implementing approach 1 here 
        // 1. find the middle most element
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!= null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 2. reverse the next half
        fast= reverse(slow.next);
        slow.next = null;
        
        slow = head;
        // compare the two lists
        while(fast != null){
            if (fast.val != slow.val) return false;
            System.out.println(fast.val);
             System.out.println(slow.val);
            fast = fast.next; 
            slow = slow.next;
        }
        
     
        return true;
    }
    
    
    public ListNode reverse(ListNode node){
        ListNode prev= null;
       
      
        while(node != null ){
            ListNode temp = node;
            node = node.next;
            temp.next = prev;
            prev = temp;
                
        }
        return prev;
        
    }
}

