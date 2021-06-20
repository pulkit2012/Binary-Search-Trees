package BST;

public class KthLargestElementBST {
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

    static class Count {
        int c;
    }


    static void KthLargestElement(int k, Node root, Count count) {
        if (root == null || count.c >= k) {
            return;
        }
        KthLargestElement(k, root.right, count);
        count.c++;
        if (count.c == k) {
            System.out.println("Kth largest element is " + root.data);
            return;
        }
        KthLargestElement(k, root.left, count);
    }

    static void kthLargest(Node root,int k) {
        Count c = new Count();
        KthLargestElement(k, root, c);
    }
    public static void main(String[] args) {
        Node root = new Node(50);
        insert(root,30);
        insert(root,20);
        insert(root,40);
        insert(root,70);
        insert(root,60);
        insert(root,80);
        kthLargest(root,2);
    }
}
