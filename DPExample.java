//Fibonaci Series
public class DPExample {

    static int fib(int n, int dp[]){
        if(n<=1){
            return n;
        }
        if (dp[n]!=0) {
            return dp[n];
        }
       dp[n]= fib(n-1,dp)+fib(n-2,dp);
       return dp[n];
    }

    public static void main(String[] args) {
        int n=50;
        System.out.println("Printing fibonacci of...."+n);
        int dp[]= new int[n+1];
        System.out.println(fib(50,dp));
      
    }

}
