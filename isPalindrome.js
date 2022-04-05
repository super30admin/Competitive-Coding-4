// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Step1 : With the help of slow and fast pointer, find the mid of linked list
// Step2 : Reverse the 2nd half of the linked list
// Step3 : Compare values of both linked list, if value matches return true else return false

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {boolean}
 */
var isPalindrome = function(head) {
    if(head === null) return true;
    let slow = head;
    let fast = head.next;
    
    while(fast !== null && fast.next !== null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    let head2 = slow.next;
    slow.next = null;
    let prev = null;
    let curr = head2;
    let next = null;
    while(curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    head2 = prev;
    while(head != null && head2 !== null) {
        if(head.val !== head2.val) return false;
        else {
            head = head.next;
            head2 = head2.next;
        }
    }
    return true;
};