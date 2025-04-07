class LinkedListPalindrome {
public boolean isPalindrome(ListNode head) {
    if(head == null || head.next == null)
        return true;
    Stack<Integer> myStack = new Stack<>();
    ListNode curr = head;

    while(curr != null){
        myStack.push(curr.val);
        curr = curr.next;
    }

    ListNode curr1 = head;

    while(curr1 != null){
        if(myStack.pop() != curr1.val)
            return false;
        curr1 = curr1.next;
    }
return myStack.isEmpty();
}
}
