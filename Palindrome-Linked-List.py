# Time Complexity - O(N)
# Space Complexity - O(1)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        # base check:
        if head == None or head.next == None:
            return True
        # Find middle node
        fast = head
        slow = head
        while(fast.next != None and fast.next.next != None):
            fast = fast.next.next
            slow = slow.next
        to_reverse = slow.next
        slow.next = None
        
        # Find Start of 2nd half of middle after reversing
        prev = None
        curr = to_reverse
        next = curr.next
        while(curr.next != None):
            curr.next = prev
            prev = curr
            curr = next
            next= next.next
        curr.next = prev
        
        end_node = curr
        
        # compare both start and end to check if palindrome or not.
        
        while(head != None and end_node != None):
            if head.val != end_node.val:
                return False
            head = head.next
            end_node = end_node.next
        return True
        