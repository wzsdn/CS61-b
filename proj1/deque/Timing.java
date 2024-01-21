package deque;
import edu.princeton.cs.algs4.Stopwatch;
import org.junit.Test;
/**
 * Created by hug.
 */
public class Timing {
    private static void printTimingTable(LinkedListDeque<Integer> Ns, LinkedListDeque<Double> times, LinkedListDeque<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }



@Test
    public  void timeLinkListDequeConstruction() {
        // TODO: YOUR CODE HERE
        LinkedListDeque<Integer> Ns=new LinkedListDeque<>();
        LinkedListDeque<Integer> opCount=Ns;
        LinkedListDeque<Integer>  Test=new LinkedListDeque<>();
        for(int i=0;i<=7;i++) Ns.addLast((1<<i)*1000);

        LinkedListDeque<Double>  times=new LinkedListDeque<>();
        for(int i=0;i<=7;i++){
            Stopwatch sw = new Stopwatch();
            for(int j=0;j<(1<<i)*1000;j++){
                Test.addLast(j);
            }
            times.addLast(sw.elapsedTime());

        }

        printTimingTable(Ns,times,opCount);
    }
    @Test
    public  void timeArryDequeConstruction() {
        // TODO: YOUR CODE HERE
        LinkedListDeque<Integer> Ns=new LinkedListDeque<>();
        LinkedListDeque<Integer> opCount=Ns;
        ArrayDeque<Integer>  Test=new ArrayDeque<>();
        for(int i=0;i<=8;i++) Ns.addLast((1<<i)*1000);

        LinkedListDeque<Double>  times=new LinkedListDeque<>();
        for(int i=0;i<=8;i++){
            Stopwatch sw = new Stopwatch();
            for(int j=0;j<(1<<i)*1000;j++){
                Test.addLast(j);
            }
            times.addLast(sw.elapsedTime());

        }

        printTimingTable(Ns,times,opCount);
    }
}

