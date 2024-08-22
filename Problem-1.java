// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Find the mid of the list and then reverse the second half and do the comparision.

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

        if(head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half
        ListNode nHead = slow.next;

        while(nHead != null){
            ListNode temp = nHead.next;
            nHead.next = prev;
            prev = nHead;
            nHead = temp;
        }

        while(prev != null && head != null){
            if(prev.val != head.val){
                return false;
            }
            prev = prev.next;
            head = head.next;
        }
        return true;
    }


    public boolean isPalindrome2(ListNode head) {
        if(head == null ) return false;
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;

        //iterate node
        while(cur != null){
            list.add(cur.val);
            cur = cur.next;
        }

        //iterate over the list
        int size = list.size() - 1;
        for(int i =0; i <= size; i++){
            if(list.get(i) != list.get(size - i)){
                return false;
            }
        }

        return true;
    }
}