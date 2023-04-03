/**
 * Time - O(2N)   ~ O(N) where N is the number of nodes in the linked list.
 * Space - O(N/2) ~ O(N)
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slowPtr = head, fastPtr = head;  
            
        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr == head ? slowPtr : slowPtr.next;
            fastPtr = fastPtr.next.next;
        }  

        fastPtr = slowPtr.next;
        slowPtr = head;

        Stack<ListNode> stack = new Stack<>();
        while(fastPtr != null){
            stack.push(fastPtr);
            fastPtr = fastPtr.next;
        }
        
        while(slowPtr != null && !stack.empty()){
            ListNode temp = stack.pop();
            if(temp.val != slowPtr.val)
                return false;
            slowPtr = slowPtr.next;
        }
        return true;
    }
}
