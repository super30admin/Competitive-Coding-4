# Time complexity is O(N) and space complexity is O(1)
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        
        slow = head
        fast = head
        
        while fast and fast.next:
            slow= slow.next
            fast = fast.next .next
            
        prev= None
        
        while slow:
            temp= slow.next
            slow.next= prev
            prev= slow
            slow= temp
            
        left= head
        right= prev
        
        while right:
            if left.val!= right.val:
                return False
            left = left.next
            right = right.next
            
        return True