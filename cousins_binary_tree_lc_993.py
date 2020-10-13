"""
Name: Srinidhi
Did it run on LC: Yes

Time Complexity: O(n)
Space Complexity: O(n)

Logic: For a x,y nodes 2 conditions need to satisfy, no common parent and belong
to same level. 

Hence Level order traversal is a natural choice.
During Level order traversal, check the condition if the parent is same
if it is, the nodes are siblings else, they can be cousins
"""
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if not root:
            return False
        
        qu = [root]
        
        while qu:
            siblings = False
            cousins = False
            
            node_at_depth = len(qu)
            
            for _ in range(node_at_depth):
                node = qu.pop(0)
                
                #if node is None, means they cannot be siblings as they do not belong to same parent
                #There is still a chance they are cousins
                if node == None:
                    siblings = False
                
                else:
                    if node.val == x or node.val == y:
                        if not cousins:
                            siblings = True
                            cousins = True
                        else:
                            return not siblings
                    if node.left:
                        qu.append(node.left)
                
                    if node.right:
                        qu.append(node.right)
                    #Adding marker
                    qu.append(None)
        
        if cousins:
            return True
        return False