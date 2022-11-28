
 //Time complexity is O(N)
 //Space complexity is O(N)
class Solution {
    ListNode orginal;
    public boolean isPalindrome(ListNode head) {
        orginal = head;
        return helper(head);
    }
    public boolean helper(ListNode curr){
        if(curr!=null){
            if(!helper(curr.next)){
                return false;
            }
            if(orginal.val!=curr.val){
                return false;
            }
            orginal=orginal.next;
        }
        return true;
    }
}