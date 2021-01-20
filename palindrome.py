# Time complexity: O(N)
# Space complexity: O(1)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverse(self, node: ListNode) -> bool:
        if not node.next:
            return node
        
        prev = self.reverse(node.next)
        node.next.next = node
        node.next = None
        return prev
    
    def isPalindrome(self, head: ListNode) -> bool:
        
        if not head or not head.next:
            return True
        
        slow = head
        fast = head
        
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        
        tail = self.reverse(slow.next)
        slow.next = None

        while head and tail:
            if head.val != tail.val:
                return False
            head = head.next
            tail = tail.next
            
        return True