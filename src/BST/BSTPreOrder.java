package BST;

public class BSTPreOrder {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class Index {
        int index = 0;
    }

    static Index index = new Index();

    static Node bstCreator(int[] preorder, Index preIndex, int lb, int ub, int size) {
        if (preIndex.index > size || lb > ub) {
            return null;
        }

        Node root = new Node(preorder[preIndex.index]);
        preIndex.index += 1;
        if (lb == ub) {
            return root;
        }
        int i;
        for (i = lb; i <= ub; i++) {
            if (preorder[i] > root.data) {
                break;
            }
        }
        root.left = bstCreator(preorder, preIndex, preIndex.index, i - 1, size);
        root.right = bstCreator(preorder, preIndex, i, ub, size);
        return root;
    }

    static Node bstUtil(int[] pre, int size) {
        return bstCreator(pre, index, 0, size - 1, size);
    }

    static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // Method 2

    static Node bstCreator2(int[] pre, Index preIndex, int max, int min, int data, int size) {


        if (preIndex.index >= size) {
            return null;
        }
        Node root = null;
        if (data < max && data > min) {
            root = new Node(pre[preIndex.index]);
            preIndex.index++;
            if (preIndex.index < size) {
                root.left = bstCreator2(pre, preIndex, data, min, pre[preIndex.index], size);
            }
            if (preIndex.index < size) {
                root.right = bstCreator2(pre, preIndex, max, data, pre[preIndex.index], size);
            }

        }
        return root;
    }
    static Node bst2Util(int[] pre,int size){
        index.index = 0;
        return bstCreator2(pre,index,Integer.MAX_VALUE,Integer.MIN_VALUE,pre[0],size);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 5, 1, 7, 40, 50};
        Node root = bstUtil(arr, arr.length);
        inOrder(root);
        System.out.println();
        Node root1 = bst2Util(arr,arr.length);
        inOrder(root1);

    }
}
