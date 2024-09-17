// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
// Travers the linked list using two pointers: fast and slow and reverse the list from the mid to the end of this list
// check if the list is palindrome by traversing the given list and the reversed list
// "static void main" must be defined in a public class.
public class Main {
    
    static class ListNode{
        int val;
        ListNode next;
        
        ListNode() {}
        
        ListNode(int v) {
            this.val = v;
            this.next = null;
        }
        
        ListNode(int v, ListNode next) {
            this.val = v;
            this.next = next;
        }
    }
    
        public static void main(String[] args) {
            
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(2);
            head.next.next.next.next = new ListNode(1);
            
            System.out.println(isPalindrome(head));
        }
        
        private static boolean isPalindrome(ListNode head) {
            if(head == null || head.next == null)
                return true;
            
            ListNode slow = head;
            ListNode fast = head;
            
            while(fast!=null && fast.next!= null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            
            slow = reverseList(slow);
            fast = head;
            
            while(slow != null) {
                if(fast.val != slow.val) {
                    return false;
                }
                fast = fast.next;
                slow = slow.next;
            }
            
            return true;
        }
        
        private static ListNode reverseList(ListNode head) {
            ListNode curr = head;
            ListNode prev = null;
            ListNode next = null;
            
            while(curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            
            return prev;
        }
    }
    