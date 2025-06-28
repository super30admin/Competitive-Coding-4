# #Brure Force: Traverse and store all node values in a list O(n). Then use two pointers (start and end) on the list to check if it’s a palindrome O(n).
# # Time: O(2n), 
# # Space: O(n), for a new list
# class Solution:
#     def isPalindrome(self, head):
#         lst = []
#         curr = head
#         while curr is not None:
#             lst.append(curr.val)
#             curr = curr.next
#         left, right = 0, len(lst) - 1
#         while left < right:
#             if lst[left] != lst[right]:
#                 return False
#             left += 1
#             right -= 1
#         return True



# Approach2: two pointers, in-place
# Find the middle. Reverse the second half. Traverse through first and reversed second half to check all the element values are same.
# TC: O(n)
# SC: O(1)
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        #base
        if head is None or head.next is None:
            return True

        #find mid
        mid = self.findmid(head)
        #reverse secod list
        reservehead = self.reverse(mid.next) #reservehead = self.reverse(mid)
        #compare 2 lists
        return self.compare(head,reservehead)

    # find mid
    def findmid(self,head)->ListNode:
        slow=head
        fast=head
        while fast.next and fast.next.next:
            slow=slow.next
            fast=fast.next.next
        return slow
    
    #reverse
    def reverse(self,head)->ListNode:
        prev=None
        curr=head

        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev

    #compare
    def compare(self,node1,node2):
        while node1 and node2:
            if node1.val != node2.val:
                return False
            node1 = node1.next
            node2 = node2.next
        return True


# # Same approach written differently
# class Solution(object):
#     def reverse(self, root):
#         prev = None
#         current = root
#         while current is not None:
#             temp = current.next
#             current.next = prev
#             prev = current
#             current = temp
#         return prev
#     def isPalindrome(self, head):
#         # find the middle
#         slow = head
#         fast = head
#         while fast.next is not None and fast.next.next is not None:
#             slow = slow.next
#             fast = fast.next.next
#         # reverse the second half
#         fast = self.reverse(slow.next)
#         slow.next = None #break the list
#         slow = head
#         # traverse through both the halves
#         while fast is not None:
#             if slow.val != fast.val:
#                 return False
#             slow = slow.next
#             fast = fast.next
#         return True

