package BST;

import java.util.Stack;

public class PreOrderToBST {
    static class Node{
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    static Node constructTree(int[] pre, int size){
        Node root = new Node(pre[0]);
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        for (int i = 1; i < size; i++) {
            Node temp = null;
            while (!stack.isEmpty() && pre[i] > stack.peek().data){
                temp = stack.pop();
            }
            if(temp != null){
                temp.right = new Node(pre[i]);
                stack.push(temp.right);
            }
            else {
                temp = stack.peek();
                temp.left = new Node(pre[i]);
                stack.push(temp.left);
            }
        }
        return root;
    }
    public static void main(String[] args) {

    }
}
