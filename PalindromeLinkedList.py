# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

#Approach 1
# T = O(n)
# S = O(n)

class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        arr = []

        while head != None:
            arr.append(head.val)
            head = head.next
        # print(arr)

        l = 0
        r = len(arr)-1

        while l <= r:
            if arr[l] != arr[r]:
                return False
            l += 1
            r -= 1

        return True


# Approach 2
# T = O(n)
# S = O(1)

class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:

        slow = head
        fast = head

        # find the mid
        while fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next

        # reverse the second half of linked list
        prev = None

        while slow != None:
            temp = slow.next
            slow.next = prev
            prev = slow
            slow = temp

        # checking if the linked list is palindrome
        left = head
        right = prev # prev will end up at the last element in linkedlist

        while right != None:
            if left.val != right.val:
                return False
            left = left.next
            right = right.next
        return True