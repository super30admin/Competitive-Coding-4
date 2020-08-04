



class Solution {
    public boolean isPalindrome(ListNode head) {
        String s = "";
        //ListNode slow = head;
        while(head != null){
            s += head.val;
            head = head.next;
        }

        int i = 0, j = s.length() - 1; 
  
        // While there are characters toc compare 
        while (i < j) { 
  
            // If there is a mismatch 
            if (str.charAt(i) != str.charAt(j)) 
                return false;  
            
            i++; 
            j--; 
        } 
  
        // Given string is a palindrome 
        return true; 
        
    }
}