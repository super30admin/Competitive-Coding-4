#Time complexity: O(n)
#Space complexity: O(1)

#Accepted on Leetcode

#Approach:
#Reverse the second half of the list and get the head of the reversed list
#Now compare left list with right list until match is found or all elements exhaused


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if head == None or head.next == None:
            return head

        #find the middle
        slow = head
        fast = head
        while fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next
        
        #reverse the 2nd half of the list
        head2 = self.reverse(slow)

        #Traverse to find if palindrome
        while head.next.next != None:
            if head.val != head2.val:
                return False
            head = head.next
            head2 = head2.next
        
        #final check
        return head.val == head2.val
    
    def reverse(self, head):
        p = None
        c = head
        n = head.next

        while c.next != None:
            c.next = p
            p = c
            c = n
            n = c.next

        c.next = p
        return c