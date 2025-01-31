public class Trees {
    public static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);

    }
}

