// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* APPROACH 1 (Stacks)
1. taking two pointers: slow and fast pointers, taking slow further by one step and fast by 2 steps. As soon as fast.next reaches null or fast.next.next reaches null, we move the pointers thus slow will give us the mid-point of the linked list.
2. We will add the elements to the stack from head till the mid.
3. Now we will compare the element coming out from the stack and mid. keep on iterating mid and elements in the stack.

APPROACH 2 (Mid and Reverse):
1. First we will find the mid-point of the linked list.
2. Then we find the reverse of the second part of the linked list starting from mid.
3. Now we will take a pointer from the head and second from the mid and iterate them, if we find the two values to be not equal, we return false. Else true.
 */

public class PalindromeLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean isPalindrome(ListNode head) {
    //base
        if(head == null)
            return true;

        ListNode mid = findMiddle(head);
        ListNode secondHead = findReverse(mid);

        ListNode p1 = head , p2 = secondHead;
        while(p1 != null){
            if(p2.val != p1.val){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;

        //Stack solution
        /*ListNode slow = head;
        ListNode fast = head;

        Stack<Integer> stack = new Stack();
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.val != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }

        return true;*/
    }

    public static ListNode findMiddle(ListNode head){
        ListNode slow = head, fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode findReverse(ListNode head){
        ListNode curr = head, prev = null;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;

            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(3);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(0);
        ListNode next3 = new ListNode(-4);
        head.next = next1;
        next1.next = next2;
        next2.next = next3;
        next3.next = null;
        System.out.println(isPalindrome(head)); //false


        ListNode head2 = new ListNode(1);
        ListNode next12 = new ListNode(2);
        ListNode next22 = new ListNode(3);
        ListNode next32 = new ListNode(2);
        ListNode next42 = new ListNode(1);
        head2.next = next12;
        next12.next = next22;
        next22.next = next32;
        next32.next = next42;
        next42.next = null;

        System.out.println(isPalindrome(head2)); //true

    }
}
