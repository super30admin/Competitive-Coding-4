// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// step 1: find midpoint using the slow and fast pointer technique
// have slow pointer start at head and fast pointer start at head.next
// keep iterating until fast AND AND fast.next is not null

// step 2: your slow pointer is at mid, but you want to reverse slow.next onwards.
// reverse slow.next.

// step 3: now your curr is set to the starting of the reversed ll. So now you run a while
// loop until curr !== null. you check to see if slow.val is NOT equal to curr.val return false.
// otherwise, return true.

// Something to keep in mind. Your exit for the third while is set to curr !== null. This is important
// because if curr is null, that means you're at the end of both lists, OR you're at the end of the reversed list,
// but your original list at an odd numbered item. So null ensures you don't check null is equal to odd, thus breaking the
// logic in place.

var isPalindrome = function (head) {
  if (head === null || head.next === null) return true;
  let slowPointer = head;
  let fastPointer = head.next;

  while (fastPointer !== null && fastPointer.next !== null) {
    slowPointer = slowPointer.next;
    fastPointer = fastPointer.next.next;
  }

  // Instead of doing all the logic inside the main func
  // we could've put some of the following logic inside
  // a helper func
  let prev = null;
  let curr = slowPointer.next;
  let fast = slowPointer.next.next;

  while (fast !== null) {
    curr.next = prev;
    prev = curr;
    curr = fast;
    fast = fast.next;
  }
  curr.next = prev;

  let slow = head;
  while (curr !== null) {
    if (slow.val !== curr.val) {
      return false;
    }
    slow = slow.next;
    curr = curr.next;
  }
  return true;
};
