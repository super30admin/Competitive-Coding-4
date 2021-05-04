/*

Thought Process: 
    -> Move slow pointer to the centre or end of first half while fast reaches end or it's next is end. 
    -> Then save the second half by storing it as slow.next and cut their connection by making slow.next = null.
    -> Then reverse the second list
    -> Compare both the lists and return result
    
    T.C -> O(N) -> 2 half-half passes
    S.C -> O(1) -> Reversing the seond half uses the same memory that was previously allocated not any extra stack space as 3 pointers goes into stack space

*/

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

// To do
class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        // Two Pass Reverse List Approach using slow, fast pointers
        if(head == null) return false;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalfList = slow.next;
        if(secondHalfList == null) return true;
        slow.next = null;
        ListNode reversedList = reverse(secondHalfList);
        
        while(reversedList != null){
            if(head.val != reversedList.val)
                return false;
            reversedList = reversedList.next;
            head = head.next;
        }
        return true;
        
        // // Two Pointer Approach
        // List<Integer> list = new ArrayList<>();
        // while(head!=null){
        //     list.add(head.val);
        //     head = head.next;
        // }
        // int low = 0, high = list.size()-1;
        // while(low<high){
        //     if(list.get(low)!=list.get(high)) return false;
        //     else{
        //         low++;
        //         high--;
        //     }
        // }
        // return true;
    }
    
    private ListNode reverse(ListNode head){
        ListNode prev = null, curr = head, next = head.next;
        while(next != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        return curr;
    }
}
