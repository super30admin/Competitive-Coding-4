// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : Even length and Odd length logic was not trivial
//TC : O(N)
//SC : O(1)

var isPalindrome = function(head) {
    if (!head || !head.next) return true;
    let current = head;
    let length = 0;
    while (current) {
        length += 1;
        current = current.next;
    }

    let mid = Math.floor(length / 2);
    current = head;
    let idx = 0;
    while (idx < mid - 1) {
        current = current.next;
        idx += 1;
    }

    let secondHalf = null;
    if (length % 2 === 0) {
        secondHalf = current.next;
        current.next = null;
    } else {
        secondHalf = current.next.next;
        current.next = null;
    }

    let prev = null;
    while (secondHalf) {
        let nextNode = secondHalf.next;
        secondHalf.next = prev;
        prev = secondHalf;
        secondHalf = nextNode;
    }

    let firstHalf = head;
    let secondHalfReversed = prev;

    while (firstHalf && secondHalfReversed) {
        if (firstHalf.val !== secondHalfReversed.val) {
            return false;
        }
        firstHalf = firstHalf.next;
        secondHalfReversed = secondHalfReversed.next;
    }

    return true;
};
