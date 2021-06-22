package BST;

public class MedianOFBST {
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
            } else if (data > root.data) {
                root.right = insert(root.right, data);
            }
        }
        return root;
    }

    //Morris Traversal
    static int counter(Node root) {
        int count = 0;
        if (root == null) {
            return count;
        }
        Node current = root;
        while (current != null) {
            if (current.left == null) {
                count++;
                current = current.right;
            } else {
                Node pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    count++;
                    current = current.right;
                }
            }
        }
        return count;
    }

    static int findMedian(Node root) {
        if(root == null){
            return 0;
        }
        int currentCount = 0;
        int count = counter(root);
        Node current = root, prev = null;
        while (current != null) {
            if (current.left == null) {
                currentCount++;
                if (count % 2 != 0 && currentCount == (count + 1) / 2) {
                    return current.data;
                } else if (count % 2 == 0 && currentCount == (count / 2) + 1) {
                    return (prev.data + current.data) / 2;
                }
                prev = current;
                current = current.right;
            } else {
                Node pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    prev = pre;
                    currentCount++;
                    if (count % 2 != 0 && currentCount == (count + 1) / 2) {
                        return current.data;
                    } else if (count % 2 == 0 && currentCount == (count / 2) + 1) {
                        return (prev.data + current.data) / 2;
                    }
                    prev = current;
                    current = current.right;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Node root = new Node(6);
        insert(root, 3);
        insert(root, 8);
        insert(root, 1);
        insert(root, 4);
        insert(root, 7);
        //insert(root, 9);
        System.out.println("Median is " + findMedian(root));

    }
}
