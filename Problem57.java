//Time Complexity: O(n)
//Space Complexity: O(1)
//Did it run on leetcode: yes
//Problems faced any: No

public class Problem57 {
    public boolean isPalindrome(ListNode head) {
        if(head==null)
            return true;

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }


        ListNode h1 = head;
        //reverse second half of the list
        ListNode h2 = reverseList(slow);
        System.out.println(slow.val);
        slow = null;
        //System.out.println(slow.val);
        //System.out.println(h2.val);

        while(h2!=null){
            if(h1.val != h2.val)
                return false;
            h1 = h1.next;
            h2 = h2.next;
        }

        return true;


    }

    private ListNode reverseList(ListNode curr){
        ListNode prev = null;
        ListNode temp;
        while(curr!=null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}