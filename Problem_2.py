# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        slow = head
        fast = head.next
        while fast!= None and fast.next!= None:
            slow = slow.next
            fast = fast.next.next
        head2 = slow.next
        slow.next = None
        
        head2 = self.reverse(head2)
        
        while head!= None and head2!= None:
            if head.val != head2.val:
                return False
            head = head.next
            head2 = head2.next
        return True
    
    def reverse(self, head: ListNode)-> ListNode:
        if head == None or head.next == None:
            return head
        prev = None
        curr = head
        fast = head.next
        while fast!= None:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev
        return curr

# Time Complexity: O(n)
# Space Complexity: O(1)