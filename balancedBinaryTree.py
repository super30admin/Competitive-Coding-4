class TreeNode:
    def __init__(self,val=0,left=None,right=None):
        self.val=val
        self.left=left
        self.right=right

class Solution:
    def isBalanced(self,root):
        def check(node):
            if not node:
                return True,0
            
            leftBalanced,leftHeight=check(node.left)
            rightBalanced,rightHeight=check(node.right)
            
            balanced=(leftBalanced and rightBalanced and abs(leftHeight-rightHeight)<=1)
            
            return balanced,max(leftHeight,rightHeight)+1
        
    
        return check(root)[0]

from collections import deque

def buildTree(values):
    if not values:
        return None
    
    root=TreeNode(values[0])
    queue = deque([root])
    i=1

    while deque and i <len(values):
        node = queue.popleft()

        if i < len(values) and values[i] is not None:
            node.left=TreeNode(values[i])
            queue.append(node.left)
        i +=1

        if i < len(values) and values[i] is not None:
            node.right=TreeNode(values[i])
            queue.append(node.right)
        i +=1

    return root

values=[1,2,2,3,3,None,None,4,4]
root=buildTree(values)

sol=Solution()
print(sol.isBalanced(root))


