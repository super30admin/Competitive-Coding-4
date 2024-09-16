'''
PROBLEM 1

TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(1)

- traverse the half of the linked list and break the linked list into 2 halves
- reverse the second half 
- traverse the both linked lists from start and keep cheking if the values are same or not, if head1.val!=head2.val, return false
'''


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if head==None or head.next==None:
            return True
        
        slow=head
        fast=head
        
        while(fast.next!=None and fast.next.next!=None):
            slow=slow.next
            fast=fast.next.next
        print(slow.val)
        
        secondHead=self.reverse(slow.next)
        slow.next=None
        print(head)
        print(secondHead)
        
        
        while(head!=None and secondHead!=None):
            if head.val!=secondHead.val:
                return False
            
            head=head.next
            secondHead=secondHead.next
        
        return True
        
        
    def reverse(self, head):
        if head==None:
            return None
        prev=None
        current=head
        fast=head.next
        
        while(fast!=None):
            current.next=prev
            prev=current
            current=fast
            fast=fast.next
        current.next=prev
        return current


'''
PROBLEM 2

TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(N)

- for every root node, calculate the height of left subtree and right subtree
- use top-to-bottom recursion to calculate the height at a root node
- return false if for any root the difference betweent the heights is more than 1

'''



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        if root==None:
            return True
        
        
        left=self.isBalanced(root.left)
        right= self.isBalanced(root.right)
        
        return abs(self.height(root.left)-self.height(root.right))<=1 and left and right
    
    def height(self, root):
        if root==None:
            return -1
        
        left=self.height(root.left)
        right= self.height(root.right)
        
        return 1+max(left, right)