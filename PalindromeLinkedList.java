//Time Complexity : O(n)
//Space Complexity : O(1)

class Solution {
    public boolean isPalindrome(ListNode head) {
        
        ListNode fast = head;
        ListNode slow = head;
        int counter = 0;
        if(head == null){return false;}
        if(head.next == null){return true;}
        while(fast != null && fast.next != null){
            
            if(fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            }
            else{
                fast = fast.next;
            }
            
            counter++;
        }
        ListNode mid = slow;
        slow = head;
        int c = counter-1;
        ListNode temp = mid;
        for (int i = 0; i<counter ; i++){
            temp = mid;
            c = counter - i - 1;
           
            if(slow.val == fast.val){
                
                slow = slow.next;
                while(c!=0){
                    
                    fast = temp.next;
                    c--;
                    temp = temp.next;
                }
                continue;
            }
            else{return false;}
        }
        return true;
    }
}
