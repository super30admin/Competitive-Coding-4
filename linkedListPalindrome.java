/*Used a stack
LeetCode all test cases passed.
TimeComplexity - O(n)
SpaceComplexity - O(n)
*/

class Solution {
    public boolean isPalindrome(ListNode head) {
        if((head==null)||(head.next==null)) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid = slow;
        Stack<ListNode> stack = new Stack<>();
        while(mid!=null){
            stack.push(mid);
            mid=mid.next;  
        }
        slow = head;
        while(!stack.isEmpty()){
            if(stack.pop().val!=slow.val) return false;
            slow=slow.next;
        }
    return true;
    }
}
