package BST;

import java.util.LinkedList;
import java.util.Vector;

public class BSTToBalancedBST {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static void inOrder(Node root, Vector<Node> nodes) {
        if (root == null) {
            return;
        }
        inOrder(root.left, nodes);
        nodes.add(root);
        inOrder(root.right, nodes);
    }

    static Node balancedTreeCreator(Vector<Node> nodes, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = nodes.get(mid);

        root.left = balancedTreeCreator(nodes,start,mid-1);
        root.right = balancedTreeCreator(nodes,mid+1,end);
        return root;
    }
    static Node balancedMain(Node root){
        Vector<Node> list = new Vector<>();
        inOrder(root,list);
        return balancedTreeCreator(list,0,list.size()-1);
    }
    static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data  +" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.left.left = new Node(7);
        root.left.left.left = new Node(6);
        root.left.left.left.left = new Node(5);
        Node tree = balancedMain(root);
        preOrder(tree);

    }
}
