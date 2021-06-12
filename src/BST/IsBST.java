package BST;

public class IsBST {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }


    static boolean isBST2(Node root) {
        return isBST2Util(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean isBST2Util(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.data > max || root.data < min) {
            return false;
        }
        boolean left = isBST2Util(root.left, min, root.data - 1);
        boolean right = isBST2Util(root.right, root.data + 1, max);
        return left && right;
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        System.out.println(isBST2(root));
    }
}
