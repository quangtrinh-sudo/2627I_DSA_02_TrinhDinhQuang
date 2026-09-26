public class SortedIntersection {

    public static void printIntersection(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int n = a.length;
        int m = b.length;

        while (i < n && j < m) {
            if (a[i] == b[j]) {
                StdOut.print(a[i] + " ");
                int val = a[i];
                
                
                while (i < n && a[i] == val) i++;
                while (j < m && b[j] == val) j++;
            } else if (a[i] < b[j]) {
                i++; 
            } else {
                j++; 
            }
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        In in1 = new In(args[0]);
        In in2 = new In(args[1]);

        int[] a = in1.readAllInts();
        int[] b = in2.readAllInts();

        printIntersection(a, b);
    }
}