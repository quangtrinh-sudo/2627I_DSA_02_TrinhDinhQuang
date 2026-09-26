import java.util.Arrays;

public class EqualPairs {

   
    public static long count(int[] a) {
        if (a == null || a.length < 2) return 0;

        
        Arrays.sort(a);

        long count = 0;
        long runLength = 1; 

        
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i - 1]) {
                runLength++;
            } else {
                
                count += runLength * (runLength - 1) / 2;
                runLength = 1; 
            }
        }
        
        count += runLength * (runLength - 1) / 2;

        return count;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();

        Stopwatch timer = new Stopwatch();
        long pairs = count(a);

        StdOut.println("Số cặp bằng nhau: " + pairs);
        StdOut.println("Thời gian thực thi: " + timer.elapsedTime() + " giây");
    }
}