# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :  Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
	# 1.Find the middle
	# 2.split the list to half
	# 3.reverse the last half
	# 4.compare the two splits
	
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if head== None or head.next == None:
            return True
        ## split the linked list in half
        
        slow = head
        fast = head.next
        while(fast!=None and fast.next != None):
            slow = slow.next
            fast = fast.next.next
        
        head2 = slow.next
        slow.next = None
        
        ## Reverse the second linked list
        
        old = None
        curr = head2
        new = None
        
        while(curr != None):
            new = curr.next
            curr.next = old
            old = curr
            curr = new
        head2 = old
        while(head != None and head2 != None):
            if head.val != head2.val:
                return False
            head = head.next
            head2 = head2.next
        return True