package BST;

public class BrothersFromDifferent {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static int counter = 0;

    static Node search(Node root, int data) {
        if (root == null || data == root.data) {
            return root;
        }
        if (data > root.data) {
            return search(root.right, data);
        }
        return search(root.left, data);
    }

    static void inOrder(int val,Node root1, Node root2) {
        if(root1 == null){
            return;
        }
        inOrder(val,root1.left,root2);
        if(search(root2,val - root1.data) != null){
            counter++;
        }
        inOrder(val,root1.right,root2);
    }

    public static void main(String[] args) {
        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(7);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);

        Node root2 = new Node(10);
        root2.left = new Node(6);
        root2.right = new Node(15);
        root2.left.left = new Node(3);
        root2.left.right = new Node(8);
        root2.right.left = new Node(11);
        root2.right.right = new Node(18);
        inOrder(16,root1,root2);
        System.out.println(counter);
    }
}
