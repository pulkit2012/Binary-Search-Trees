package BST;

public class InorderSuccessor {
    static class Node{
        int data;
        Node left,right,parent;

        public Node(int data) {
            this.data = data;
            left = right = parent = null;
        }
    }
    static Node insert(Node root,int value){
        if(root == null){
            return new Node(value);
        }
        else {
            Node temp = null;
            if(value < root.data){
                temp = insert(root.left,value);
                root.left = temp;
            }
            else {
                temp = insert(root.right,value);
                root.right = temp;
            }
            temp.parent = root;
        }
        return root;
    }
    static Node inOrderSuccessor(Node root, Node node){
        if(node.right != null){
            return minValue(node.right);
        }
        Node p = node.parent;
        while (p != null && node == p.right){
            node = p;
            p = p.parent;
        }
        return p;
    }
    static Node minValue(Node root){
        Node curr = root;
        while (curr.left != null){
            curr = curr.left;
        }
        return curr;
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
        Node root = new Node(8);
        insert(root, 3);
        insert(root, 10);
        insert(root, 1);
        insert(root, 6);
        insert(root, 4);
        insert(root, 7);
        insert(root, 14);
        insert(root, 13);
        Node temp = root.left.right;
        inOrder(root);
        System.out.println();
        System.out.println(inOrderSuccessor(root,temp).data);
    }
}
