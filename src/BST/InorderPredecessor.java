package BST;

public class InorderPredecessor {
    static class Node {
        int data;
        Node left, right, parent;

        public Node(int data) {
            this.data = data;
            left = right = parent = null;
        }
    }

    static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node temp = null;
            if (data < root.data) {
                temp = insert(root.left, data);
                root.left = temp;
            } else {
                temp = insert(root.right, data);
                root.right = temp;
            }
            temp.parent = root;
            return root;
        }
    }

    static Node inOrderPredecessor1(Node root, Node node) {
        if (node.left != null) {
            return maxVal(node.left);
        } else {
            Node p = node.parent;
            while (p != null && node == p.left) {
                node = p;
                p = p.parent;
            }
            return p;
        }
    }

    static Node maxVal(Node root) {
        Node curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr;
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        insert(root, 3);
        insert(root, 10);
        insert(root, 1);
        insert(root, 6);
        insert(root, 4);
        insert(root, 7);
        insert(root, 14);
        insert(root, 13);
        Node temp = root.left.right.right;
        System.out.println(inOrderPredecessor1(root, temp).data);
    }
}
