public class doublyLinkedList {
    public static class Node {
        int data;
        Node previous;
        Node next;
        Node(int data){
            this.data=data;
            this.next=this.previous=null;
        }
            
    }

    Node head=null;
    Node tail=null;
    void insert(int data){
        Node newnNode=new Node(data);
        if (head==null) {
            head=tail=newnNode;
        }
        else{
            tail.next=newnNode;
            newnNode.previous=tail;
            tail=newnNode;
        }

    }

    void printList(){
        Node current=head;
        while (current!=null) {
            System.out.println(current.data);
        }
    }
}
