'''
234. Palindrome Linked List
Link: https://leetcode.com/problems/palindrome-linked-list/description/
'''

# Time Complexity : O(n) for traversing the linked list
# Space Complexity : O(1) for the optimized approach, as we are not using any additional data structures
# Did this code successfully run on Leetcode : Yes, it passed all test cases.
# Any problem you faced while coding this : Yes, initially I used a brute force approach which was not optimal in terms of space complexity. The optimized approach using the fast and slow pointer technique was more efficient.

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        # Brute force approach: Convert linked list to a list and check if it is a palindrome. Here, Time Complexity is O(n) and Space Complexity is O(n) because we are using an additional list to store the values of the linked list.
        # nums = [] # humne ek empty list banayi hai jisme linked list ke values store karenge (We created an empty list to store the values of the linked list)
        # while head is not None: # jab tak head None nahi hai tab tak hum values ko list me append karte rahenge (We will keep appending values to the list until the head is None)
        #     nums.append(head.val) # hum head ke value ko list me append karte hain (We append the value of the head to the list)
        #     head = head.next # head ko next node par le jaate hain (We move the head to the next node)
        # # ab hum check karte hain ki kya list palindrome hai (Now we check if the list is a palindrome)
        # # hum left aur right pointers banate hain (We create left and right pointers)
        
        # left, right = 0, len(nums) - 1 # left pointer ko 0 par aur right pointer ko last index par set karte hain (We set the left pointer to 0 and the right pointer to the last index)
        # while left < right: # jab tak left pointer right pointer se chhota hai tab tak hum check karte hain (We check until the left pointer is less than the right pointer)
        #     if nums[left] != nums[right]: # agar left aur right pointers ke values alag hain toh yeh palindrome nahi hai (If the values at the left and right pointers are not equal, then it is not a palindrome)
        #         return False # hum False return karte hain (We return False)
        #     else: # agar values barabar hain toh hum left aur right pointers ko update karte hain (If the values are equal, we update the left and right pointers)
        #         left += 1 # hum left pointer ko aage badhate hain (We move the left pointer forward)
        #         right -= 1 # hum right pointer ko peeche le jaate hain (We move the right pointer backward)
        # return True # agar humne loop complete kar liya toh yeh palindrome hai (If we complete the loop, then it is a palindrome)
    
        # Optimized approach: Reverse the second half of the linked list and compare it with the first half. Here, Time Complexity is O(n) and Space Complexity is O(1) because we are not using any additional data structures.
        # We can also use the fast and slow pointer technique to find the middle of the linked list, reverse the second half, and then compare it with the first half.
        if not head or not head.next:
            return True
        # hum slow aur fast pointers banate hain (We create slow and fast pointers)
        slow = head # slow pointer ko head par set karte hain (We set the slow pointer to the head)
        fast = head # fast pointer ko head par set karte hain (We set the fast pointer to the head)
        # hum fast aur slow pointers ko move karte hain (We move the fast and slow pointers)
        while fast and fast.next: # jab tak fast aur fast.next None nahi hain tab tak hum pointers ko move karte hain (We move the pointers until fast and fast.next are not None)
            slow = slow.next # slow pointer ko aage badhate hain (We move the slow pointer forward)
            fast = fast.next.next # fast pointer ko do steps aage badhate hain (We move the fast pointer two steps forward)
        # ab slow pointer middle par hai (Now the slow pointer is at the middle)
        # hum second half ko reverse karte hain (We reverse the second half)
        prev = None # hum prev pointer ko None par set karte hain (We set the prev pointer to None)
        while slow: # jab tak slow pointer None nahi hai tab tak hum reverse karte hain (We reverse until the slow pointer is None)
            next_node = slow.next # hum next_node ko slow.next par set karte hain (We set the next_node to slow.next)
            slow.next = prev # hum slow.next ko prev par set karte hain (We set slow.next to prev)
            prev = slow # hum prev ko slow par set karte hain (We set prev to slow)
            slow = next_node # hum slow ko next_node par set karte hain (We set slow to next_node)
        # ab prev pointer second half ke head par hai (Now the prev pointer is at the head of the second half)
        # ab hum first half aur second half ko compare karte hain (Now we compare the first half and the second half)
        left, right = head, prev # hum left pointer ko head par aur right pointer ko prev par set karte hain (We set the left pointer to head and the right pointer to prev)
        while right: # jab tak right pointer None nahi hai tab tak hum compare karte hain (We compare until the right pointer is None)
            if left.val != right.val: # agar left aur right pointers ke values alag hain toh yeh palindrome nahi hai (If the values at the left and right pointers are not equal, then it is not a palindrome)
                return False
            left = left.next # hum left pointer ko aage badhate hain (We move the left pointer forward)
            right = right.next # hum right pointer ko aage badhate hain (We move the right pointer forward)
        return True # agar humne loop complete kar liya toh yeh palindrome hai (If we complete the loop, then it is a palindrome)
    