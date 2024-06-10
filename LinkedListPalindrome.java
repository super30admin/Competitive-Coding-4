//time complexity:O(n)
//space complexity:O(1)
public class LinkedListPalindrome {
    public static class Node {

        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node reverseLinkedList(Node head) {
        // Check if the list is empty or has only one node
        if (head == null || head.next == null) {

            return head;
        }

        Node newHead = reverseLinkedList(head.next);

        Node front = head.next;

        front.next = head;
        head.next = null;
        return newHead;
    }

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        Node newHead = reverseLinkedList(slow.next);

        Node first = head;

        Node second = newHead;
        while (second != null) {
            if (first.data != second.data) {
                reverseLinkedList(newHead);

                return false;
            }

            first = first.next;

            second = second.next;
        }

        reverseLinkedList(newHead);

        return true;
    }

    public static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(5);
        head.next.next = new Node(2);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(1);

        System.out.print("Original Linked List: ");
        printLinkedList(head);

        if (isPalindrome(head)) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }

}

