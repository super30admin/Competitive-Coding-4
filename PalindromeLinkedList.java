//Time Complexity:O(n)
//Space Complexity:O(n)
/*Approach
-going till mid of List using slow and fast pointers
-reversing second half of the list
-Now comparing each node whenever a node comes where value is not same then list is not palindrome
 */

class PalindromeLinkedList{
    public static class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
       
        public boolean isPalindrome(ListNode head) {
            if(head == null)return true;
            ListNode slow = head;
            ListNode fast = head.next;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            fast = slow.next;
            slow.next = null;
            slow = head;
            fast = reverse(fast);
            while(fast != null){
                if(slow.val != fast.val)return false;
                slow = slow.next;
                fast = fast.next;
            }
            return true;
        }
        
        private ListNode reverse(ListNode head){
            if(head == null || head.next == null)return head;
            ListNode rev = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return rev;
        }
        public static void main(String args[]){
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(2);
            head.next.next.next = new ListNode(1);

            PalindromeLinkedList obj = new PalindromeLinkedList();
            System.out.println(obj.isPalindrome(head));
        }
}