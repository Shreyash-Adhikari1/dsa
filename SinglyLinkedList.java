public class SinglyLinkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    Node head = null;
    Node tail = null;
    void addNode(int data){
        Node newnode = new Node(data);
        if(head == null){
            head = tail = newnode;
            // head = newnode;
        }
        else{
            tail.next = newnode;
            tail = newnode;
            /* Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newnode;
            */
        }
    }

    void insertHeadFirst(int data){
        Node newnode = new Node(data);
        if(head == null){
            head = tail = newnode;
        }
        else{
            newnode.next=head;
            head=newnode;
            
        }
    }

    void printList(){
        Node current=head;
        while (current!=null) {
            System.out.println(current.data);
        }
    }

}