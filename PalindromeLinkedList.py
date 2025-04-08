# Time Complexity: O(2n)
# Space Complexity: O(1)

from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reverseLinkedList(self, head: Optional[ListNode]) -> ListNode:

       temp = head
       prev = None
       while(temp != None):
            front = temp.next
            temp.next = prev
            prev = temp
            temp = front
       return prev
    

    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if head is None or head.next is None:
            return True
        slow = head
        fast = head
        while(fast.next is not None and fast.next.next is not None):
            slow = slow.next
            fast = fast.next.next
    
        newHead  =  self.reverseLinkedList(slow.next) 
        first = head
        second = newHead
        while(second is not None):
            if first.val != second.val:
                self.reverseLinkedList(newHead)
                return False
            first = first.next
            second = second.next
        self.reverseLinkedList(newHead)
        return True    

        