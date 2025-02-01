import java.util.List;

//Time Complexity: O(n)
// Space Complexity: O(n)

public class PalindromeLL {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
        public boolean isPalindrome(ListNode head) {
            List<Integer> ll = new ArrayList<>();
            ListNode curr = head;
            while(curr != null){
                ll.add(curr.val);
                curr = curr.next;
            }
            int first =0, last = ll.size()-1;
            while(first <= last){
                if(ll.get(first) != ll.get(last)){
                    return false;
                }
                first++;
                last--;
            }
            return true;
        }

//Time Complexity: O(n)
// Space Complexity: O(1)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode fast=head.next,slow = head;
            while(fast != null && fast.next !=null){
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode revHead = reverse(slow.next);
            ListNode curr = head;
            while(revHead != null){
                if(curr.val != revHead.val){
                    return false;
                }
                revHead = revHead.next;
                curr = curr.next;
            }
            return true;
        }

        public ListNode reverse(ListNode root){
            ListNode prev = null;
            ListNode curr = root;
            while(curr != null){
                ListNode nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }
            return prev;
        }
    }

}
