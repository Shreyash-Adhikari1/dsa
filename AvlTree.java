public class AvlTree{
    public static class Node{
        int data;
        Node left;
        Node right;
        int height;
        Node(int data){
            this.left=this.right=null;
            this.height=1;
            this.data=data;
        }
    }
    Node createBST(Node root, int data){
        if(root==null){
            return new Node(10);
        }
        if(data<root.data){
            root.left=createBST(root.left, data);
        }
        else if(data>root.data){
            root.right=createBST(root.right, data);
        }
        else{
            return root;
        }
        root.height=1+ Math.max(getHeight(root.left),getHeight(root.right));
        int balancefactor=getBalanceFactor(root);
        //LEFT LEFT
        if(balancefactor>1 && data<root.left.data){
        return rightRotation(root);
        }

        // LEFT RIGHT
        if(balancefactor>1 && data>root.left.data){
        root.left = leftRotation(root.left);
        return rightRotation(root);
        }

        //RIGHT RIGHT
        if(balancefactor<-1 && data>root.right.data){
      
        return leftRotation(root);
        }

        //RIGHT LEFT
        if(balancefactor<-1 && data<root.right.data){
       
        root.right = rightRotation(root.right);
        }

        return root;
    }

    Node rightRotation(Node y){
        Node x = y.left;
        Node t2=x.right;
        x.right = y;
        y.left = t2;
        y.height=1+Math.max(getHeight(y.left),getHeight(y.right));
        x.height = 1+Math.max(getHeight(x.left),getHeight(x.right));
        return x;
    }

    Node leftRotation(Node x){
        Node y = x.right;
        Node t2 = y.left;
        y.left = x;
        x.right =t2;
        x.height=1+Math.max(getHeight(x.left),getHeight(x.right));
        y.height = 1+Math.max(getHeight(y.left),getHeight(y.right));
        return y;
    }


    int getHeight(Node root){
        if (root==null){
            return 0;
        }
        return root.height;
    }
    int getBalanceFactor(Node root){
        if(root==null){
            return 0;
        }
        return getHeight(root.left)-getHeight(root.right);
    }
}