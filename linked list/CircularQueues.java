
public class CircularQueues {
    int queue[];
    int front=-1;
    int rear =-1;
    int size;

    CircularQueues(int size){
        this.size=size;
        queue= new int [size];
    }

    void enqueue(int data){
        if (isFull()) {
            System.out.println("Queue is full");
        }
        if (front==-1) {
            front=0;
        }
        rear=(rear+1)%size;
        queue[rear]=data;

    }

    int dequeue(){
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        if (front==rear) {
            int temp=front;
            front=rear=-1;
            return queue[temp];
        }
        int temp=front;
        front = (front+1)%size;
        return queue[temp];  
    }

    boolean isFull(){
        return (rear+1)%size==front;
    }

    boolean isEmpty(){
        return front==-1 && rear==-1;
    }
}
