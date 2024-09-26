'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 234. Palindrome Linked List
# Given the head of a singly linked list, return true if it is a palindrome.


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

#-----------------
# Time Complexity: 
#-----------------
# O(N) - Need to iterate over N/2 elements to find mid, need to iterate over N/2
#      - elements to find simulataneously to find palindrome
#------------------
# Space Complexity: 
#------------------
# O(1): Only temporary variables used. Constant space. 

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes


class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        slow = fast = head
        fast = fast.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        # print(slow)
        temp = slow.next
        slow.next = None
        slow = temp
        
        current = slow
        reversed_second_half = None
        
        while current:
            temp = current.next
            current.next = reversed_second_half
            reversed_second_half = current
            current = temp

        current, current_2 = head, reversed_second_half
        
        while current and current_2:
            if current.val != current_2.val:
                return False
            else:
                current, current_2 = current.next, current_2.next

        return True            
        