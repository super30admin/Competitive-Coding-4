class PalindromeLL {
    ListNode temp=null;
    public static class ListNode
    {
        int val;
        ListNode next;

        ListNode()
        {

        }
        ListNode(int val)
        {
            this.val = val;
        }
        ListNode(int val, ListNode next)
        {
            this.val = val;
            this.next = next;
        }
    ListNode front;
    public boolean isPalindrome(ListNode head) {
        if(head == null)
        {
            return true;
        }
        if(front == null)
        {
            front=head;
            System.out.println(front.val);
        }
        boolean bool= isPalindrome(head.next);
        if(front.val==head.val)
        {
            front=front.next;
        }
        else
            bool= false;
        return bool;
    }
}

//Time complexity is O(n)
//Space complexity is O(n). Since we're building the recursive stack.

//    class Solution {
//        public boolean isPalindrome(ListNode head) {
//            if(head==null)
//            {
//                return true;
//            }
//            ListNode slow = head;
//            ListNode fast = head;
//            while(fast.next!=null&&fast.next.next!=null)
//            {
//                slow = slow.next;
//                fast = fast.next.next;
//            }
//            fast=head;
//            ListNode temp = reverseL(slow.next);
//            slow.next = null;
//            while(fast!=null && temp!=null)
//            {
//                if(temp.val==fast.val)
//                {
//                    temp=temp.next;
//                    fast=fast.next;
//                }
//                else
//                    return false;
//            }
//            return true;
//        }
//        private ListNode reverseL(ListNode root)
//        {
//            if(root==null)
//                return null;
//            ListNode prev = null;
//            ListNode cur = root;
//            ListNode Next;
//            while(cur!=null)
//            {
//                Next = cur.next;
//                cur.next = prev;
//                prev = cur;
//                cur=Next;
//            }
//            return prev;
//
//        }
//    }


//Time complexity is O(n)
//Space complexity is O(1).