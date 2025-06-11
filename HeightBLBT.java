// Time Complexity : O(n)
// Space Complexity : O(1)

class Node {
    int val;
    Node left;
    Node right;
    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Bst {
    Node root = new Node(3, new Node(9, null, null), new Node(20, new Node(15, null, null), new Node(7, null, null)));
    public Bst() {

    }
}

public class HeightBLBT {
    boolean is_balanced = true;
    public int getHeight(Node root) {
        if (root == null) return 0;
        int height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        return height;
    }

    public void isBalanced(Node root) {
        if (is_balanced == true && (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1)) {
            is_balanced = false;
        }
    }
    public static void main(String[] args){
        Bst bst = new Bst();
        HeightBLBT blbt = new HeightBLBT();
        blbt.isBalanced(bst.root);
        System.out.println(blbt.is_balanced);
    }
}
