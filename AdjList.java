import java.util.ArrayList;
import java.util.List;

public class AdjList {
    public static void main(String[] args) {
        AdjList a =new AdjList(5);
        a.addEdge(0,1);
        a.addEdge(0,2);
        a.addEdge(0,4);
        a.addEdge(1,3);
        a.addEdge(2,3);
        a.addEdge(3,4);
        a.printGraph();
    }

    int vertices;
    SinglyLinkedList adjlist[];

    AdjList(int vertices){
        this.vertices=vertices;
        adjlist= new SinglyLinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjlist[i]= new SinglyLinkedList();

        }
    }

    void addEdge(int u, int v){
        adjlist[u].addNode(v);
        adjlist[v].addNode(u);
    }  

    List<Integer> getAdjNodes(int i){
        List<Integer> adjnodes= new ArrayList<>();
        SinglyLinkedList.Node current =adjlist[i].head;
        while (current!=null) {
        
        }


        return adjnodes;
    }

    void printGraph(){
        for ( int i = 0; i < vertices; i++) {
            System.out.print(i+" is connected to");
            SinglyLinkedList.Node current=adjlist[i].head;
            while (current!=null) {
                System.out.print(current.data+", ");
                current=current.next;
            }
            System.out.println("");
        }
    }
}
//Critically analyze time complexities of adjacency list & adjacency matrix