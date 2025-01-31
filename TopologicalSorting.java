import java.util.Queue;

public class TopologicalSorting {
    int toposort(int adjmatrix[][], int v){
        int indegree[]= new int [v];
        Queues q = new Queues(v);

        //calculate indegree
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (adjmatrix[i][j]!=0) {
                    indegree[j]++;
                }
            }
        }
        //add/enqueue vertices having 0 indegree [independent vertices]
        for (int i = 0; i < v; i++) {
            if (indegree[i]==0) {
                q.enqueue(i);
            }
        }

        int count =0;//cycle xaina bhaney count=vertices hunxa || cycle xa bhaney count!=vertices hunxa
        while (!q.isEmpty()) {
            count++;
            int x = q.dequeue();
            System.out.println(x);//print ordering
            for (int j = 0; j < v; j++) {
                if (adjmatrix[x][j]!=0) {
                    indegree[j]--;
                    if (indegree[j]==0) {
                        q.enqueue(j);
                    }
                }
            }
        }
        if (count!=v) {
            System.out.println("Cycle Detected!!!");
            return 1;
        }
        return-1;
    }

}
