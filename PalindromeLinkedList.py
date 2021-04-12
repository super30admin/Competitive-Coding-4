# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Time Complexity is O(n)
# Space Complexity is O(1)
class Solution(object):
    def reverseList(self,head):
        if head is None:
            return head
        prev = None
        curr = head
        nextt = head.next
        while(nextt):
            
            temp = nextt.next
            nextt.next = curr
            curr.next = prev
            
            prev = curr
            curr = nextt
            nextt = temp
        
        return curr
            
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        slow = head
        fast = head
        while(fast.next and fast.next.next):
            slow = slow.next
            fast = fast.next.next
        
        first = head
        reverse = self.reverseList(slow.next)
        slow.next = None
        while(reverse):
            
            if(reverse.val != first.val):
                return False
            reverse = reverse.next
            first = first.next
        return True