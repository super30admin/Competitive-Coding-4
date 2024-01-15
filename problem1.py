#Time Complexity :O(N)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode :yes

# Definition for singly-linked list.
class ListNode:
     def __init__(self, val=0, next=None):
         self.val = val
         self.next = next
class Solution:
    def isPalindrome(self, head: [ListNode]) -> bool:
        if not head or not head.next:
            return True

        # Find the middle of the linked list
        slow = head
        fast = head.next

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # Reverse the second half of the linked list
        head2 = self.reverselist(slow.next)
        slow.next = None

        # Compare the reversed second half with the first half
        while head and head2:
            if head.val != head2.val:
                return False
            head = head.next
            head2 = head2.next

        return True

    def reverselist(self, head):
        pre = None
        curr = head

        while curr is not None:
            temp = curr.next
            curr.next = pre
            pre = curr
            curr = temp

        return pre
        