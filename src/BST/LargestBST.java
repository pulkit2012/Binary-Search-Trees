package BST;

public class LargestBST {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class BstInfo {
        int min, max;
        int size;
        boolean isBST;

        public BstInfo(int min, int max, int size, boolean isBST) {
            this.min = min;
            this.max = max;
            this.size = size;
            this.isBST = isBST;
        }
    }

    static BstInfo largestBST(Node root) {
        if (root == null) {
            return new BstInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }
        BstInfo left = largestBST(root.left);
        BstInfo right = largestBST(root.right);

        BstInfo info = null;
        if (left.isBST && right.isBST && root.data > left.max && root.data < right.min) {
            info = new BstInfo(Math.min(root.data, Math.min(left.min, right.min)), Math.max(root.data, Math.max(left.max, right.max)), left.size + 1 + right.size, true);
        } else {
            info = new BstInfo(0, 0, Math.max(left.size, right.size), false);
        }
        return info;

    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(15);
        root.right = new Node(8);
        root.left.left = new Node(12);
        root.left.right = new Node(20);
        root.right.left = new Node(5);
        root.right.right = new Node(9);
        root.left.left.left = new Node(2);
        root.left.left.right = new Node(14);
        root.right.left.left = new Node(4);
        root.right.left.right = new Node(7);
        root.right.right.right = new Node(10);
        System.out.println(largestBST(root).size);
    }
}
