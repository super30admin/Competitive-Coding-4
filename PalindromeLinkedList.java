class PalindromeLinkedList {

    //Time Complexity O(n)
    //Space Complexity O(n)

    public boolean isPalindrome(ListNode head) {

        Stack<Integer> stack = new Stack<Integer>();

        ListNode current = head;

        while (current != null) {
            stack.add(current.val);
            current = current.next;
        }

        current = head;
        while (current != null) {

            if (stack.pop() != current.val) {
                return false;
            }
            current = current.next;

        }

        return true;

    }

}