"""
Time: O(n)
Space: O(1)
Leet: Accepted
Problems: None
"""

class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if head is None or head.next is None:
            return True

        slow = head
        fast = head.next

        #Split list into half
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        #Store second half starting from head2
        head2 = slow.next
        slow.next = None

        #reverse linked list
        prev = None
        curr = head2
        nex = None
        while curr:
            nex = curr.next
            curr.next = prev
            prev = curr
            curr = nex
        
        head2 = prev

        #validate reversed second list with first list
        while head2:
            if head.val != head2.val:
                return False
            head = head.next
            head2 = head2.next

        return True
