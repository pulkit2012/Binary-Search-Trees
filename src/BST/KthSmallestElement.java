package BST;

import java.util.Arrays;
import java.util.Scanner;

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

    static int kthSmallest2(Node root, int k) {
        int count = 0;
        int smallest = Integer.MIN_VALUE;
        Node curr = root;
        while (curr != null) {
            if (curr.left == null) {
                count++;
                if (count == k) {
                    smallest = curr.data;
                }
                curr = curr.right;
            } else {
                Node pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    pre.right = null;
                    count++;
                    if (count == k) {
                        smallest = curr.data;
                    }
                    curr = curr.right;
                }
            }
        }
        return smallest;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        insert(root, 3);
        insert(root, 6);
        insert(root, 2);
        insert(root, 4);
        insert(root, 1);
        //insert(root, 14);
        Node node = kthSmallest(root, 3);
        System.out.println(node == null ? "tree is not that deep" : node.data);
        System.out.println(kthSmallest2(root,3));

    }
}