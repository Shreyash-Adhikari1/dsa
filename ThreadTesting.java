class PrintDocument{
    synchronized void printDoc(String doc, int n){
        for(int i = 0; i <n; i++){
            System.out.println("printing document "+doc+" "+i+";");
        }
        
    }
}

class mythread extends Thread{
    PrintDocument pref;
    mythread(PrintDocument pref){
        this.pref = pref;
    }
    @Override
    public void run(){
        pref.printDoc("ago", 10);
    }
}

class yourthread extends Thread{
    PrintDocument pref;
    yourthread(PrintDocument pref){
        this.pref = pref;
    }
    @Override
    public void run(){
        pref.printDoc("java", 10);
    }
}



public class ThreadTesting{ //extends A implememts Runnable {

    public void run(){
        for(int i = 0; i<10; i++){
            System.out.println("cat" + i + ".jpg");
        }
    }

    public static void main(String[] args) {
        System.out.println("app start");

       /* ThreadTesting t = new ThreadTesting();
        Thread thrd = new Thread(t);
        thrd.start();

        for(int i = 0; i<10; i++){
            System.out.println(i);
        }*/

        PrintDocument pref = new PrintDocument();
        mythread t1 = new mythread(pref);
        yourthread t2 = new yourthread(pref);

        t1.start();
        t2.start();
        // try{
        //     t1.join();
        // }catch(Exception ee){
        //     ee.printStackTrace();
        // }

            System.out.println("app end"); 
    }
    
}