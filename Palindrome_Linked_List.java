// TC : O(n)
// SC : O(1)
class Solution {
    private ListNode reverseIt(ListNode node) {
        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode temp, fast, slow, reversed;
        // 1 - 2 - 3 - 2 - 1 - null
        fast = head;
        slow = head;
        temp = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next; // 3 - 1
            slow = slow.next; // 2 - 3
        }
         reversed = reverseIt(slow); // 2 - 1 - null
        //reversed -->  1 - 2 - null
        while(reversed != null) {
            if(temp.val != reversed.val)
                return false;
            reversed = reversed.next;
            temp = temp.next;
        }
        return true;
    }
}

// TC : O(n)
// SC : O(n)
// Recursion method

class Solution {
    ListNode headptr = null;
    private ListNode reverseIt(ListNode node, ListNode prev) {
        if(node == null) {
          headptr = prev;
          return null;
        }
        ListNode temp = reverseIt(node.next, node);
        node.next = prev;
        temp = node;
        return temp;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode temp, fast, slow, reversed;
        // 1 - 2 - 3 - 2 - 1 - null
        fast = head;
        slow = head;
        temp = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next; // 3 - 1
            slow = slow.next; // 2 - 3
        }
         reverseIt(slow, null); // 2 - 1 - null
        reversed = headptr;
        //reversed -->  1 - 2 - null
        while(reversed != null) {
            if(temp.val != reversed.val)
                return false;
            reversed = reversed.next;
            temp = temp.next;
        }
        return true;
    }
}
