import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PalindromeLinkedList {
    //my initial approach
    //overall time complexity 4*O(n) = O(n), overall space complexity 2*O(n) = O(n)
    public static boolean isPalindromeLists(ListNode head) {
        List<Integer> straight = new ArrayList<>();
        ListNode temp = head; //store head into a temp variable for later use

        while(head != null) { //O(n) T.C, O(n) S.C
            straight.add(head.val); //traverse all nodes and store its values to a list of integers
            head = head.next;
        }

        List<Integer> reverse = reverse(temp); //perform reverse of linked-list on temp node
        //and also store its values in a list

        //if both lists are equal, then it is a palindrome
        return Objects.equals(straight, reverse); //O(n)
    }

    static List<Integer> reverse(ListNode head) {
        List<Integer> reverse = new ArrayList<>();

        if(head == null) return reverse;

        ListNode prev = null;
        ListNode current = head;
        ListNode fast = head.next;

        //reversing
        while(fast != null){ //O(n) T.C
            current.next = prev;
            prev = current;
            current = fast;
            fast = fast.next;
        }
        current.next = prev;

        //adding to a list
        while(current != null) { //O(n) T.C, O(n) S.C
            reverse.add(current.val);
            current = current.next;
        }
        return reverse;
    }

    //approach from video
    //overall T.C is O(n/2) + O(n/2) + O(n/2) = O(n)
    //overall S.C is O(1) as even though we create a new temp node,
    // we essentially split the total initial length into two halves and store.
    public static boolean isPalindromePointers(ListNode head) {
        if(head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        //finding middle node
        while(fast.next != null && fast.next.next != null) { //O(n/2) T.C as fast moves at twice speed
            // and reaches the end in n/2 traversals
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next; //from middle to end of linked-list, we store it in a new head node
        slow.next = null; //make the initial list end at the middle node
        head2 = reverseListNode(head2); //reverse the second part of the list, i.e., from head2

        while(head2 != null) { //O(n/2) T.C as only until half of the original list is traversed
            if(head.val != head2.val) return false; //if at any point values are not equal, it is not palindrome
            head = head.next; //traverse initial head -> mid
            head2 = head2.next; //traverse mid -> end
        }

        return true; //if until the end of the second list, all nodes are found to be equal, it is a palindrome
    }

    static ListNode reverseListNode(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;

        while(fast != null) { //O(n) T.C, where n is here half of the total original length of nodes
            // i.e., essentially n/2 of total complexity
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;

        return curr;
    }

    public static void main(String[] args) {
        // Construct the sample palindrome linked list: 1 -> 2 -> 2 -> 1
        ListNode node4 = new ListNode(1);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        // Check if the linked list is a palindrome
        boolean isPalindromeLists = isPalindromeLists(head);
        boolean isPalindromePointers = isPalindromePointers(head);

        // Print the result
        System.out.println("Is the linked list a palindrome using array lists approach? " +
                isPalindromeLists);

        System.out.println("Is the linked list a palindrome using mid and pointers approach? " +
                isPalindromePointers);
    }
}