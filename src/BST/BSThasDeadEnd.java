package BST;

import java.util.HashMap;
import java.util.HashSet;

public class BSThasDeadEnd {
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
        }
        return root;
    }

    static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(1 + left, 1 + right);
    }

    static boolean isDeadEnd(Node root, int min, int max) {
        if (root == null) {
            return false;
        }
        if (min == max) {
            return true;
        }
        return isDeadEnd(root.left, min, root.data - 1) || isDeadEnd(root.right, root.data + 1, max);
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        insert(root, 5);
        insert(root, 2);
        insert(root, 3);
        insert(root, 7);
        insert(root, 11);
        insert(root, 4);
        System.out.println(isDeadEnd(root, 1, Integer.MAX_VALUE));
        System.out.println(height(root));
    }
}
