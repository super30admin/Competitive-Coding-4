# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        
        #Base case, when no head present or just single node exists, it's a palindrome
        if not head or head.next == None:
            return True
        
        #1. Find the middle of the list 
        slow = head
        fast = head.next
        
        while fast!=None and fast.next != None:
            slow = slow.next
            fast = fast.next.next
            
        #2. Break the list into two parts and assign slow.next to second head, and then to null
        head2 = slow.next
        slow.next = None
        
        curr = head2
        temp = None
        prev= None
        
        #3. Reverse the second list
        while curr != None:
            
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
            
        head2 = prev
        
        #4. Check if values at each node are equal, if not return False: else return True
        while head!=None and head2!= None:
            if head.val == head2.val:
                head = head.next
                head2 = head2.next
            else:
                return False
        
        return True
            
        
        