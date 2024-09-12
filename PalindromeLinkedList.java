/**
 * Time Complexity : O(n)
 * Space Complexity: O(n) - no extra space used
 * Idea:
 * 1. Find the middle node with slow and fast pointers
 * 2. reverse the second half of the list
 * 3. Comparing all nodes of first half and second half beinf same its a palindrome
 * Leetcode : Yes
 */

class PalindromeLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void printList(ListNode head){
        ListNode curr = head;
        while(curr != null){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;

        //find middle
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse second half
        ListNode curr  = slow.next;
        ListNode prev = null;

        while(curr != null){
            ListNode temp = curr;
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = temp;
            curr = nextNode;            
        }

        slow.next = prev;
        printList(head);

        // compare
        slow = head;
        fast = prev;

        while(fast != null){
            if(slow.val != fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    
    public static void main(String[] args){
        System.out.println("PalindromeLinkedList");
        PalindromeLinkedList obj = new PalindromeLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        //head.next.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);

       System.out.println(obj.isPalindrome(head));
    }
}
