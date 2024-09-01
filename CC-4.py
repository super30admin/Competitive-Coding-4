# 234. Palindrome linked list		https://leetcode.com/problems/palindrome-linked-list/	

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if head == None or head.next == None:
            return True

        #1 find middle element
        slow = head
        fast = head

        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next

        #2. reverse 2nd half of LL
        fast = self.reverse(slow.next)
        slow.next = None

        #3. comparing 2 LL
        return self.isEqual(head, fast)


    def reverse(self, head: Optional[ListNode]) -> ListNode:
        prev = None
        curr = head
        fast = head.next
        while fast != None:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev

        return curr

    def isEqual(self, l1: ListNode, l2: ListNode) -> bool:
        while l1 and l2:
            if l1.val != l2.val:
                return False
            l1 = l1.next
            l2 = l2.next
        return True
# TC = O(n), SC = O(1) 
        

# 110. Height Balanced Binary Tree		https://leetcode.com/problems/balanced-binary-tree/	

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        self.isvalid = True
        self. dfs(root)
        return self.isvalid 

    def dfs(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return 0

        leftn = self.dfs(root.left)
        rightn = self.dfs(root.right)

        if leftn == None or rightn == None:
            return 0

        if abs(leftn - rightn) > 1:
            self.isvalid = False
        else:
            return max(leftn, rightn) + 1
# TC = O(n), SC = O(h)
        