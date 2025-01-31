public class BST {
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
            this.left=this.right=null;
        }
    }

    public Node insertBST(Node root, int data){
        if(root==null){
            return new Node(data);
        }
        if(data>root.data){
            root.right=insertBST(root.right, data);
        }
        else if(data<root.data){
            root.left=insertBST(root.left, data);
        }
        return root;
    }

    public Node deleteBST(Node root, int data){
        if(root==null){
            return null;
        }
        if(data<root.data){
            root.left=deleteBST(root.left, data);
        }
        if(data>root.data){
            root.right=deleteBST(root.right, data);
        }
        else{
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            else{
                //two children case
                root.data=findMin(root.right);
                root.right=deleteBST(root.right, root.data);
            }
        }

        return root;
    }

    int findMin(Node root){
        int minval=root.data;
        while(root.left!=null){
            minval=root.left.data;
            root=root.left;
        }
        return minval;
    }

    public static void main(String[] args) {
        BST bst=new BST();
        Node root= bst.insertBST(null, 10);
        root=bst.insertBST(root, 15);
    }
}