import java.util.*;

public class LRUcaching {

    public static class Node{
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value){
            this.key=key;
            this.value=value;
            this.prev=this.next=null;
        }

    }
    //node class end
    int capacity;
    HashMap<Integer,Node> map;
    LRUcaching(int capacity){
        this.capacity=capacity;
        map= new HashMap<>();
    }

    void put(int key, int value){
        if (map.containsKey(key)) {
            //remove node
            removeNode(map.get(key));
            
        }
        else if (map.size()==capacity) {
            //remove tail
            removeNode(dummytail.prev);
        }
        Node newnode=new Node(key, value);
        insert(newnode);
    }

    int get(int key){
        Node node=map.get(key);
        if (node!=null) {
            //remove node
            removeNode(node);
            //reinsert hat node
            insert(node);
            return node.value;
        }
        return -1;
    }

    void removeNode(Node node){
        map.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
        node.next=node.prev=null;

    }

    Node dummyhead=new Node(0,0);
    Node dummytail= new Node(0, 0);

    void insert(Node newnode){
        map.put(newnode.key, newnode);
        if (dummyhead.next==null) {
            dummyhead.next=newnode;
            dummytail.prev=newnode;
            newnode.prev=dummyhead;
            newnode.next=dummytail;
        }
        else{
            newnode.prev=dummyhead;
            newnode.next=dummyhead.next;
            dummyhead.next.prev=newnode;
            dummyhead.next=newnode;
        }

    }
    
}
