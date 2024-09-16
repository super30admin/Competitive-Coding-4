/*
TC: O(N)
find middle: O(N)
reverse list inplace: O(N)
compare: O(N)

SC: O(1) no extra space used

1. Find the mid point of the list.
2. Reverse the second half.
3. Traverse first half and second half. If they are not uniform - not a palindrome.

*/

public class PalindromeLinkedList {
    
    public boolean isPalindrone(Node head){
        if(head == null) return true;
        Node slow = head, fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        if(fast != null){
            slow = slow.next;
        }

        slow = reverse(slow);

        while(slow != null){
            if(head.val != slow.val){ 
                return false;
            }
            head = head.next;
            slow = slow.next;
        }

        return true;
    }

    private Node reverse(Node head){
        Node prev = null, next = null;
        while(head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        //head.next.next.next = new Node(3);

        PalindromeLinkedList ll = new PalindromeLinkedList();
        System.out.println(ll.isPalindrone(head));
        
    }
}

class Node{

    int val;
    Node next;

    public Node(int val){
        this.val = val;
    }
}
