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



// ******************** half size stack two pointers ********************
// Time Complexity:  O(n)
// Space Complexity: O(n)

class Solution {
    public boolean isPalindrome(ListNode head) {
      
        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> stack = new Stack<>();
      
        while(fast != null && fast.next != null) {                                     // push node values of first half
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
      
        if(fast != null)                                                               // if odd number of values put slow to starting of second half (i.e. n=5 then put slow from 3rd to 4th node to be compared with 2nd node)
            slow = slow.next;
      
        while(slow != null) {                                                          // comparing firest half with values coming out of stack(second half in reversed order)
            if(slow.val != stack.pop())
                return false;
            slow = slow.next;
        }
      
        return true;
    }
}




// // ******************** without space reversing linked list two pointers ********************
// // Time Complexity:  O(n)
// // Space Complexity: O(1)

// class Solution {
//     public boolean isPalindrome(ListNode head) {
//         ListNode slow = head;
//         ListNode fast = head;
//         while(fast != null && fast.next != null) {                             // set fast at end of linkedlist, slow at mid of linkedlist
//             fast = fast.next.next;
//             slow = slow.next;
//         }
//         ListNode p2 = null;
//         ListNode p1;
//         while(slow != null) {                                                  // reversing second half of linkedlist
//             p1 = slow.next;
//             slow.next = p2;
//             p2 = slow;
//             slow = p1;
//         }
//         p1 = head;
        
//         while(p2 != null) {                                                    // comparing first half with reversed second half
//             if(p1.val != p2.val)
//                 return false;
//             p1 = p1.next;
//             p2 = p2.next;
//         }
//         return true;
//     }
// }




// // ******************** without space reversing linked list ********************
// // Time Complexity:  O(n)
// // Space Complexity: O(1)

// class Solution {
//     public boolean isPalindrome(ListNode head) {
      
//         ListNode p1 = head;
//         ListNode p2 = head;
//         ListNode cur = head;
//         ListNode prev = null;
//         ListNode extra;
//         int size = 0;
      
//         while(cur != null) {                                                      // calculating size of linkedlist
//             cur = cur.next;
//             size++;
//         }
      
//         int mid = size/2;
      
//         while(mid > 0) {                                                          // set p2 at mid
//             p2 = p2.next;
//             mid--;
//         }
      
//         while(p2 != null) {                                                       // reverse linked list from p2(second half)
//             extra = p2.next;
//             p2.next = prev;
//             prev = p2;
//             p2 = extra;
//         }
      
//         while(prev != null) {                                                     // compare values of first half with reversed second half
//             if(p1.val != prev.val)
//                 return false;
//             p1 = p1.next;
//             prev = prev.next;
//         }
      
//         return true;
      
//     }
// }



// // ******************** Full size stack ********************
// // Time Complexity:  O(n)
// // Space Complexity: O(n)

// class Solution {
//     public boolean isPalindrome(ListNode head) {
//         ListNode cur = head;
//         Stack<Integer> stack = new Stack<>();
//         while(cur != null) {
//             stack.push(cur.val);                                                          // we push every node values in stack
//             cur = cur.next;
//         }
//         cur = head;
//         while(cur != null) {        
//             if(cur.val != stack.pop())                                                    // popping out values from stack(LIFO) and compare list node values from start
//                 return false;
//             cur = cur.next;
//         }
//         return true;
//     }
// }
