# https://leetcode.com/problems/palindrome-linked-list/

# Approach
# Find mid of the Linked List. Pass mid.next to reversedList function that will reverse the second half of the linked list and return at fast pointer
# Set mid.next = None and set slow pointer back to head. while fast != None and slow != None, check if fast.val == slow.val
# If yes, increment fast and slow pointer. If its not same, return False. Else, Return True 

# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def reversedList(self,root):
        prev= root
        curr = root.next
        prev.next = None

        while(curr != None):
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev

    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if head.next == None:
            return True
            
        slow = head
        fast = head

        while(fast.next != None and fast.next.next != None):
            fast = fast.next.next
            slow = slow.next
        
        fast = self.reversedList(slow.next)
        slow.next = None
        slow = head

        while(fast != None and slow != None):
            if fast.val == slow.val:
                fast = fast.next
                slow = slow.next
            else:
                return False
        return True