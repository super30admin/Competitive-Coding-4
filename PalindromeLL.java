/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//Time Complexity:O(N);
//Space Complexity: O(N);
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next == null) {
            return true;
        }
        ListNode fast= head;
        ListNode slow =head;
        Stack<ListNode> st = new Stack<>();
        while(fast.next!=null && fast.next.next!=null){
            st.push(slow);
            slow=slow.next;
            fast= fast.next.next;
        }
        st.push(slow);

        if(fast.next==null){
            st.pop();
        }

        ListNode sl=slow.next;
        while(sl!=null){
            if(st.pop().val != sl.val){
                return false;
            }else{
                sl=sl.next;
            }
        }
        return true;
    }
}