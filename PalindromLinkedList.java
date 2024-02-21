// Time Complexity : O(n) // We are end up traversing list n+n/2 which is n
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Came up with logic quickly, but to code, it took a lot time.

/*
Use Two Pointers: Fast and Slow.
Find Middle
Reverse the second part of list from slow.next and handle odd-even size list.
Start iterating from head for 1st part and reversehead from last to mid part (2nd part)
Compare: If same - Palindrom. Or not.
*/

public class PalindromLinkedList {

    class ListNode {
        int val;
        ListNode next;

        ListNode(){}//empty constructor
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    private ListNode reverse(ListNode node){

        ListNode prev = null;
        ListNode curr = node;
        ListNode tmp = null;

        while(curr.next!= null){
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        curr.next = prev;

        ListNode printme = curr;
        System.out.println("Printing reverse list");
        while(printme != null){
            System.out.print(printme.val + "\t");
            printme = printme.next;
        }

        return curr;
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;

        //find middle
        ListNode slow = head;
        ListNode fast = head;
        //Odd length && even length
        while(fast.next !=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //head, slow, fast

        //reverse the 2nd part of list
        ListNode revhead = null;
        if(fast.next == null) //Odd Length LinkedList
            revhead = reverse(slow);
        else // even length LinkedList
            revhead = reverse(slow.next);

        slow.next = null; //break between first and second part of the list
        // ^^ even if we won't break then also fine. Just handle in logic

        while(head != null){
            if(head.val != revhead.val){
                return false;
            }else
            {
                head = head.next;
                revhead = revhead.next;
            }
        }
//       If we are being asked to restore the original list then it has to be handled for odd and even list
        return true;
    }

    public static void main(String[] args) {
        PalindromLinkedList obj = new PalindromLinkedList();
        ListNode head = obj.new ListNode(1);
//        head.next = obj.new ListNode(2);
//        head.next.next = obj.new ListNode(2);
//        head.next.next.next = obj.new ListNode(1);

        head.next = obj.new ListNode(0);
        head.next.next = obj.new ListNode(1);

        ListNode print = head;
        while(print!= null){
            System.out.print(print.val);
            System.out.print("\t");
            print = print.next;
        }
        System.out.println("List is Palindrom? : " + obj.isPalindrome(head));
    }
}