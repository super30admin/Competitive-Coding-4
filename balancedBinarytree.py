# The main concept here is that we need to see if height of left and right subtree diffrs by at most 1 so calculate recursively height of all left and right subtrees and then aadd 1 to it, then consioder the heoght as max of left and right subtree height
# Time Complexity: O(h)
# Space Complexity: O(1)
def  isBalaanced(root):
    if root is None:
        return True
    return isBalaanced(root.left) and isBalaanced(root.right) and abs(height(root.left-height(root.right)))<=1

def height(root):
    if root is None:
        return 0
    else:
        return(max(height(root.left),height(root.right))+1)

