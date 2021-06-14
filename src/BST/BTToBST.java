package BST;

import java.util.Arrays;

public class BTToBST {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static int[] arr;
    static int index = 0;

    static void btToArray(Node root, int[] inOrder1) {
        if (root == null) {
            return;
        }
        btToArray(root.left, inOrder1);
        inOrder1[index] = root.data;
        index++;
        btToArray(root.right, inOrder1);
    }

    static int counterNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return counterNodes(root.left) + counterNodes(root.right) + 1;
    }

    static void arrayToBST(Node root,int[] arr) {
        if (root == null) {
            return;
        }
        arrayToBST(root.left,arr);
        root.data = arr[index];
        index++;
        arrayToBST(root.right,arr);
    }

    static void bstCreator(Node root) {
        if (root == null) {
            return;
        }
        int n = counterNodes(root);
        int[] arr = new int[n];
        btToArray(root,arr);
        Arrays.sort(arr);
        index = 0;
        arrayToBST(root,arr);
    }

    static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(30);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.right.right = new Node(5);
        inOrder(root);
        System.out.println();
        bstCreator(root);
        inOrder(root);
    }
}
