package BST;

public class LCA {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static Node LCA1(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }
        if (n1 < root.data && n2 < root.data) {
            return LCA1(root.left, n1, n2);
        }
        if (n1 > root.data && n2 > root.data) {
            return LCA1(root.right, n1, n2);
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        System.out.println(LCA1(root,10,14).data);
    }
}
