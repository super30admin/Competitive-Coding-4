#Approach
# Find the mid of the linked list and reverse the second part of the list
#compared the two list one by one untill the end of sencond list


# complexities
# Time : O(n)
# Space : O(1)



# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
from typing import Optional





class Solution:
    def reverseLinkedList(self, head):
        prev = None
        curr = head
        while curr != None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev

    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow = head  # 1x
        fast = head.next  # 2x

        if head.next == None:
            return True

        while fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next

        fast = self.reverseLinkedList(slow.next)
        slow = head
        while fast != None:
            if fast.val != slow.val:
                return False
            slow = slow.next
            fast = fast.next

        return True




