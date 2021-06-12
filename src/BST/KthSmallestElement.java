package BST;

public class KthSmallestElement {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            if (data < root.data) {
                root.left = insert(root.left, data);
            } else {
                root.right = insert(root.right, data);
            }
            return root;
        }
    }


    static int count = 0;

    static Node kthSmallest(Node root, int k) {
        if (root == null) {
            return null;
        }
        Node left = kthSmallest(root.left, k);
        if (left != null) {
            return left;
        }
        count++;
        if (k == count) {
            return root;
        }
        return kthSmallest(root.right, k);
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        insert(root, 8);
        insert(root, 22);
        insert(root, 4);
        insert(root, 12);
        insert(root, 10);
        insert(root, 14);
        Node node = kthSmallest(root, 3);
        System.out.println(node == null ? "tree is not that deep" : node.data);

    }
}
