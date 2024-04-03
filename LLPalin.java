/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * 
 * class Solution {
 * // Using stack
 * public boolean isPalindrome(ListNode head) {
 * //Tc: O(n) Sc: O(1)
 * ListNode slow = head;
 * ListNode fast = head;
 * 
 * while (fast != null && fast.next != null) {
 * fast = fast.next.next;
 * slow = slow.next;
 * }
 * 
 * if (fast != null)
 * slow = slow.next;
 * 
 * slow = revList(slow);
 * fast = head;
 * 
 * while (slow != null) {
 * if (fast.val != slow.val)
 * return false;
 * 
 * fast = fast.next;
 * slow = slow.next;
 * }
 * return true;
 * }
 * 
 * private ListNode revList(ListNode head) {
 * ListNode cur = head;
 * ListNode prev = null;
 * 
 * while (cur != null) {
 * ListNode temp = cur.next;
 * cur.next = prev;
 * prev = cur;
 * cur = temp;
 * }
 * 
 * return prev;
 * }
 * }
 * 
 * 
 * 
 * 
 * /*
 * public boolean isPalindrome(ListNode head) {
 * int len = 0;
 * ListNode cur = head;
 * while(cur != null)
 * {
 * cur = cur.next;
 * len++;
 * }
 * ListNode temp = head;
 * Stack<Integer> st = new Stack<>();
 * for(int i = 0; i < len/2; i++)
 * {
 * st.push(temp.val);
 * temp = temp.next;
 * }
 * if (len % 2 != 0) {
 * temp = temp.next;
 * }
 * 
 * while (temp != null) {
 * if (st.pop() != temp.val) {
 * return false;
 * }
 * temp = temp.next;
 * }
 * return true;
 * 
 */