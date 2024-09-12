// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
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
var isPalindrome = function (head) {
    if (head === null || head.next === null)
        return true;
    let slow = head;
    let fast = head;
    // Move fast twice. Slow will reach the middle value
    while (fast !== null && fast.next !== null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    // Reverse the 2nd half
    let curr = slow;
    let prev = null;
    while (curr != null) {
        let next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    // Compare the 2 halfs
    let ll1 = head;
    while (ll1 !== null && prev !== null) {
        if (ll1.val !== prev.val)
            return false;
        ll1 = ll1.next;
        prev = prev.next;
    }
    return true;
};