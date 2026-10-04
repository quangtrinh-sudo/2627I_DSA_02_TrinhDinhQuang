import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class KthFromLast {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        Queue<String> q = new Queue<>();

        while (!StdIn.isEmpty()) {
            q.enqueue(StdIn.readString());
            if (q.size() > k) {
                q.dequeue();
            }
        }

        StdOut.println(q.dequeue());
    }
}