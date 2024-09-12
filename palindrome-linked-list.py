'''
TC: O(n)
SC: O(1)

'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        
        if not head or not head.next:
            return True
        
        
        slow, fast = head, head
        prev = None
        back = None
        
        while fast and fast.next:
            prev = slow
            slow = slow.next
            fast = fast.next.next
        
        def reverse(node):
            if not node:
                return node
            
            curr = node.next
            prev = node
            prev.next = None
            
            while curr:
                temp = curr.next
                curr.next = prev
                prev = curr
                curr = temp
            
            return prev
        
        if not fast:
            back = reverse(slow)
            prev.next = None
        elif not fast.next:
            back = reverse(slow.next)
            prev.next = None
            # slow.next = None
        
        front = head
        
        while front and back:
            if front.val != back.val:
                return False
            front = front.next
            back = back.next
        
        return True
        
        
            
        