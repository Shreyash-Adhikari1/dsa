//This is code for cycle detection (FindCycle)
public class DisjointSet {
   int parent[];
   int size[];
   int vertices;
   DisjointSet(int vertices){
    this.vertices=vertices;
    parent= new int[vertices];
    size = new int[vertices];
    for(int i=0; i<vertices; i++){
        parent[i]=-1;
    }
   } 

   void findCycle(int u, int v){

    int uabsroot=find(u);// u absolute root
    int vabsroot=find(v);//v absolute root
    if (uabsroot==vabsroot) {
        //cycle detected
        System.out.println("Cycle detected");
        return ;
    }
    //add edge in graph
    union(uabsroot,vabsroot);
   }

   void union(int uabsroot, int vabsroot){
    if (size[uabsroot]>size[vabsroot]) {
        parent[vabsroot]=uabsroot;
    }else if (size[uabsroot]<size[vabsroot]) {
        parent[uabsroot]=vabsroot;
    }else{
        parent [vabsroot]=uabsroot;
        size[uabsroot]++;
    }
   }

   int find(int u){
    if (parent[u]==-1) {
        return u;
    }
    return parent[u]=find(parent[u]);
   }

   public static void main(String[] args) {
    DisjointSet d = new DisjointSet(4);
    d.findCycle(0, 1);
    d.findCycle(1, 3);
    d.findCycle(3, 2);
    d.findCycle(0, 2);
   }
}
