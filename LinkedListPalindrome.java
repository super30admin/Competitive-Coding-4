//Solved successfully on leetcode and faced no issues
//Time complexity : O(n) Space complexity : O(1)

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode firsthalf = head;
        ListNode midnode = middlenode(head);
        ListNode secondhalf = midnode.next;
        midnode.next = null;
        return compare(firsthalf , reverse(secondhalf));
    }
    private boolean compare(ListNode firsthalf, ListNode secondhalf){
        ListNode l1 = firsthalf;
        ListNode l2 = secondhalf;
        while(l1!=null && l2!=null){
            if(l1.val != l2.val){
                return false;
            }
            l1  = l1.next;
            l2  = l2.next;
        }
        return true;
    }
    private ListNode middlenode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
        }
    private ListNode reverse(ListNode head){
        ListNode prev  = null;
        ListNode curr = head;
        ListNode temp = null;
        while(curr!=null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            }
        return prev;
        }
    }
