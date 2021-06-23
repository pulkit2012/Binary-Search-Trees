package BST;

import java.util.Arrays;

public class ReplaceEveryLeastFromRight {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static Node root;
    static Node succ;

    public ReplaceEveryLeastFromRight() {
        root = null;
        succ = null;
    }

    static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            if (data < root.data) {
                succ = root;
                root.left = insert(root.left, data);
            } else {
                root.right = insert(root.right, data);
            }
        }
        return root;
    }

    static void replace(int[] arr, int n) {
        for (int i = n - 1; i >= 0; i--) {
            succ = null;
            root = insert(root, arr[i]);
            if (succ != null) {
                arr[i] = succ.data;
                ;
            } else {
                arr[i] = -1;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 58, 71, 18, 31,
                32, 63, 92, 43, 3,
                91, 93, 25, 80, 28};
        int n = arr.length;
        replace(arr,n);
        System.out.println(Arrays.toString(arr));
    }
}
