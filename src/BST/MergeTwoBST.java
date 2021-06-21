package BST;

import java.util.Vector;

public class MergeTwoBST {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static void inOrder(Node root, Vector<Integer> vector) {
        if (root == null) {
            return;
        }
        inOrder(root.left, vector);
        vector.add(root.data);
        inOrder(root.right, vector);
    }

    static Vector<Integer> merger(Node root1, Node root2) {
        Vector<Integer> list1 = new Vector<>();
        Vector<Integer> list2 = new Vector<>();
        Vector<Integer> list3 = new Vector<>();
        inOrder(root1, list1);
        inOrder(root2, list2);
        int i = 0;
        int j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) > list2.get(j)) {
                list3.add(list2.get(j));
                j++;
            } else {
                list3.add(list1.get(i));
                i++;
            }
        }
        while (i < list1.size()) {
            list3.add(list1.get(i));
            i++;
        }
        while (j < list2.size()) {
            list3.add(list2.get(j));
            j++;
        }
        return list3;
    }

    static Node bstUtil(Vector<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node node = new Node(list.get(mid));

        node.left = bstUtil(list, start, mid - 1);
        node.right = bstUtil(list, mid + 1, end);
        return node;
    }

    static Node bstFromMerge(Node root1, Node root2) {
        Vector<Integer> list = merger(root1, root2);
        return bstUtil(list, 0, list.size() - 1);
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
        Node root1 = new Node(100);
        root1.left = new Node(50);
        root1.right = new Node(300);
        root1.left.left = new Node(20);
        root1.left.right = new Node(70);

        Node root2 = new Node(80);
        root2.left = new Node(40);
        root2.right = new Node(120);

        Node root3 = bstFromMerge(root1, root2);
        inOrder(root3);
    }
}
