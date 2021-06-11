package BST;

public class FindAValue {
    static class Node{
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    static void insert1(Node node,int value){
        if(value < node.data){
            if(node.left != null){
                insert1(node.left,value);
            }
            else {
                node.left = new Node(value);
            }
        }
        else if(value > node.data){
            if(node.right != null){
                insert1(node.right,value);
            }
            else {
                node.right = new Node(value);
            }
        }
    }
    static Node search(Node root,int value){
        if(root == null || root.data == value){
            return root;
        }
        if(value > root.data){
           return search(root.right,value);
        }
        return search(root.left,value);
    }
    static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        insert1(root,30);
        insert1(root,20);
        insert1(root,40);
        insert1(root,70);
        insert1(root,60);
        insert1(root,80);
        inOrder(root);
    }
}
