# Time Complexity :
# O(N)

# Space Complexity :
# O(1)

# Did this code successfully run on Leetcode :
#Yes

#We first find the mid point of the linked list. Then we split the linked list. 
#After that, we reverse the first half of the linked list. Then we compare the the new lists that we have element wise
#If all elements are same, then it is a palindrome, otherwise it is not 


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        #Base case
        if head == None:
            return False
        
        if head.next == None:
            return True

        #Finding the length
        temp_ptr = head
        length = 0
        while (temp_ptr != None):
            temp_ptr = temp_ptr.next
            length += 1

        #Finding the mid point
        if length % 2 == 0 :
            mid_point = length/2 + 1
        else :
            mid_point = length/2 + 2

        ptr_1 = head
        ptr_2 = head

        curr_loc = 1

        while (curr_loc < int(mid_point)):
            curr_loc = curr_loc +1
            ptr_2 = ptr_2.next
        
        curr_loc = 1
        #Break the link
        while(curr_loc < int(length/2)) :
            curr_loc += 1
            ptr_1 = ptr_1.next

        ptr_1.next = None
        ptr_1 = head

        # Reverse the first half
        ptr_1 = self.reverse(ptr_1)

        #Compare the elements
        while (ptr_1 != None and ptr_2 != None):
            if ptr_1.val != ptr_2.val:
                return False 
            ptr_1 = ptr_1.next
            ptr_2 = ptr_2.next
        
        return True

    def reverse(self,head):
        if head == None :
            return 

        prev = None
        curr = head
        next_ptr = head.next

        while (next_ptr != None):
            curr.next = prev
            prev = curr
            curr = next_ptr
            next_ptr = next_ptr.next

        curr.next = prev
        return curr
