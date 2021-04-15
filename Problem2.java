//234.palandromic linked list
//tc - O(n)
//sc - O(1)


public class Problem2 {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        Problem2 p = new Problem2();
        System.out.println(p.isPalindrome(head));
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;
        ///find the middle node
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next!= null){
            fast = fast.next.next; //3,1
            slow = slow.next; //2,3
        }
        //
        ListNode reversed = reverse(slow.next); //2
        //System.out.println(reversed.val);
        slow.next = null;
        slow = head;
        //compare first half and second half

        while(slow != null && reversed != null){
            if(slow.val != reversed.val){
                return false;
            }
            else{
                slow = slow.next;
                reversed = reversed.next;
            }
        }
        // if(slow.next != null && reversed.next == null){
        //     return true;
        // }
        
        return true;
        
    }
    public ListNode reverse(ListNode head){
        if(head == null)
            return null;
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = head;
        while(curr != null){
            next = curr.next; //2
            curr.next = prev; 
            prev = curr; //1
            curr = next; //2
        }
        return prev;
        
    }

    
}
