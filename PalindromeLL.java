// Time complexity : O(n)
// Space Complexity : O(n)

class Node {
    int val;
    Node next;
    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

class Sll {
    Node root = new Node(11, new Node(7, new Node(11, null)));
    public Sll() {

    }
}

public class PalindromeLL {
    Sll ll;
    boolean is_palindrome;
    public PalindromeLL() {
        ll = new Sll();
        is_palindrome = true;
    }
    public void reverseLL(Node root, int cnt) {
        if (root == null){
            return;
        }
        cnt++;
        reverseLL(root.next, cnt);
        Node temp = ll.root;
        for (int i = 0; i < 3-cnt; i++){
            temp = temp.next;
        }
        if (temp.val != root.val && is_palindrome) {
            is_palindrome = false;
            System.out.println("not a palindrome");
        }
    }

    public static void main(String[] args) {
        PalindromeLL pll = new PalindromeLL();
        pll.reverseLL(pll.ll.root, 0);
        System.out.println(pll.is_palindrome);
    }
}
