import java.util.List;
// import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;

public class MinimumSpanningTree{

    public static void main(String[] args) {
        MinimumSpanningTree a = new MinimumSpanningTree(5);
        a.addEdge(0,1,10);
        a.addEdge(0,2,5);
        a.addEdge(0,5,100);
        a.addEdge(1,2,2);
        a.addEdge(1,3,5);
        a.addEdge(2,3,3);
        a.addEdge(2,4,20);
        a.addEdge(3,5,2);
        a.addEdge(2,3,3);
        a.addEdge(4,5,5);
        a.printGraph();
    }



    //edges list
    public static class Edge implements Comparable<Edge>{
        int u;
        int v;
        int w;
        Edge(int u, int v, int w){
            this.u=u;
            this.v=v;
            this.w=w;
        }
        @Override
        public int compareTo(MinimumSpanningTree.Edge o) {
            return this.w-o.w;
        }
    }


    int vertices;
    int matrix[][];

    //Edge array to fill all edge list
    Edge edges [];
    
    
    MinimumSpanningTree(int vertices){
        this.vertices = vertices;
        matrix = new int[vertices] [vertices];
        edges= new Edge[vertices*(vertices-1)/2]; //mst[MInimum Spanning Tree]
    }

    //here u & v are starting and ending points
    int edgeindx=-1;//mst
    void addEdge(int u, int v, int w){
        matrix[u][v]=w;
        matrix[v][u]=w;
        edges[++edgeindx]=new Edge(u,v,w);//mst
    }

    void krushkal(){
        int [] parent = new int [vertices];
        int [] size = new int[vertices];
        int [][] mst = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i]=-1;

        }
        Arrays.sort(edges);
        int edgeTaken=0;
        int edgeounter=-1;
        while (edgeTaken<vertices) {
            Edge e = edges[++edgeounter];
            int uabsroot= find(e.u, parent);
            int vabsroot=find(e.u, parent);
            if (uabsroot==vabsroot) {
                continue;
            }
            mst[e.u][e.v]=e.w;
            mst[e.v][e.u]=e.w;
            union(uabsroot, vabsroot, size, parent);
            edgeTaken++;
        }
    }

    void union(int uabsroot, int vabsroot, int size[], int parent[]){
        if (size[uabsroot]>size[vabsroot]) {
            parent[vabsroot]=uabsroot;
        }else if (size[uabsroot]<size[vabsroot]) {
            parent[uabsroot]=vabsroot;
        }else{
            parent [vabsroot]=uabsroot;
            size[uabsroot]++;
        }
  
       }
    
       int find(int u,int parent[]){
        if (parent[u]==-1) {
            return u;
        }
        return parent[u]=find(parent[u],parent);
       }
    

   
    void printGraph(){
        for (int i = 0; i < vertices; i++) {
            System.out.print(i+" is connected to ");
            for (int j = 0; j < vertices; j++) {
                if (matrix[i][j]!=0) {
                    System.out.print(j+", ");
                    
                }
            }
            System.out.println("");
        }
    }

    // write function to print matrix

    List<Integer>getAdjNodes(int i){
        List<Integer> adjlist = new ArrayList<>();
        
    

        for (int j = 0; j < vertices; j++) {
            if (matrix[i][j]!=0) {
                adjlist.add(j);
            }
        }

        return adjlist;
    }

    void shortestPathUnweightedGraph(int sources){

        int dist[]=new int[vertices];
        int prevpath[]= new int [vertices];
        for (int i = 0; i <vertices; i++) {
            dist[i]=Integer.MAX_VALUE;
            prevpath[i]=-1;
        }
        dist[sources]=0;
        Queues q = new Queues(vertices);
        boolean [] visited = new boolean[vertices];
        q.enqueue(sources);
        visited[sources] = true; 
        while(!q.isEmpty()){
            int x=q.dequeue();
            System.out.println(x);
            for(int j = 0; j<vertices; j++){
                if(matrix[x][j]!=0){
                    if(!visited[j]){
                        if (dist[x]+1<dist[j]) {
                            dist[j]=dist[x]+1;
                            prevpath[j]=x;
                        }
                        q.enqueue(j);
                        visited[j]=true;
                    }
                }
            }

        } 
    }

    void BFS(int sources){
        Queues q = new Queues(vertices);
        boolean [] visited = new boolean[vertices];
        q.enqueue(sources);
        visited[sources] = true; 
        while(!q.isEmpty()){
            int x=q.dequeue();
            System.out.println(x);
            for(int j = 0; j<vertices; j++){
                if(matrix[x][j]!=0){
                    if(!visited[j]){
                        q.enqueue(j);
                        visited[j]=true;
                    }
                }
            }

        } 
    }
    int dijakstra(int source, int destination){
        int dist[]= new int[vertices];
        int prevpath[] = new int[vertices];
        boolean visited[] = new boolean[vertices];
        for(int i = 0; i<vertices; i++){
            dist[i] = Integer.MAX_VALUE;
            prevpath [i] =-1;
        }
        dist[source] = 0;
        for(int i = 0; i<vertices; i++){
            int minvertex = findMinvertex(dist, visited);
            visited[minvertex] = true;
            for(int j = 0; j<vertices; j++){
                if(matrix[minvertex] [j]!=0){
                    if(!visited[j]&&dist[minvertex]+matrix[minvertex] [j]<dist[j]){
                        dist[j] = dist[minvertex] + matrix[minvertex] [j];
                        prevpath[j] = minvertex;
                    }
                }
            }
        }
        // print path
        Stack<Integer> stk = new Stack<>();
        int x = destination;
        stk.push(x);
        while ((prevpath[x]!=-1)) {
            x = prevpath[x];
            stk.push(x);
        }

        // printing path from s to d using stack
        while(!stk.isEmpty()){
            System.out.println(stk.pop());
        }


        return dist [destination];
    }
    int findMinvertex(int dist[], boolean visited[]){
        int min = -1;
        for(int i = 0; i<dist.length; i++){
            if(min==1&&!visited[i] || dist[i]<dist[min]&&!visited[i]){
                min = i;
            }
        }
    return 1;
    }
}