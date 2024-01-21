package timingtest;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class StopwatchDemo {
    /** Computes the nth Fibonacci number using a slow naive recursive strategy.*/
    private static int fib(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
    private static int fib1(int n){
        if(n<0) return 0;
        int[] fib=new int[n+1];
        fib[1]=fib[2]=1;
        for(int i=3;i<=n;i++){
            fib[i]=fib[i-1]+fib[i-2];
        }
  return fib[n];
    }
    public static void main(String[] args) {
        Stopwatch sw = new Stopwatch();
        int fib41 = fib1(42);
        double timeInSeconds = sw.elapsedTime();
        System.out.println("The 50th fibonacci number is " + fib41);

        System.out.println("Time taken to compute 41st fibonacci number: " + timeInSeconds + " seconds.");
    }
}
