
//Definition for singly-linked list.
     class ListNode {
           int val;
           ListNode next;
           ListNode() {}
           ListNode(int val) { this.val = val; }
           ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class PalindromeLinkedList {
    static ListNode head4;
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        slow = reverse(slow);

        while(slow!=null && fast!=null){
            if(slow.val!= fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode reverse(ListNode current){
        ListNode prev = null;
        ListNode next = null;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    void printList(ListNode node)
    {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
    public static void main(String[] args){
        PalindromeLinkedList p =new PalindromeLinkedList();
        p.head4 = new ListNode(85);
        p.head4.next = new ListNode(15);
        p.head4.next.next = new ListNode(15);
        p.head4.next.next.next = new ListNode(85);

        System.out.println("Given Linked list");
        p.printList(head4);
        System.out.println("");
        System.out.println("reversed Linked list");
        p.printList(head4);
        System.out.println("");
        System.out.println(p.isPalindrome(head4));

    }
}