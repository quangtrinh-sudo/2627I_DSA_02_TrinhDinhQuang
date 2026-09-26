public class BinarySearch {

    
    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        int result = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (a[mid] == key) {
                result = mid; 
                hi = mid - 1; 
            } else if (a[mid] < key) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        int key = Integer.parseInt(args[1]);

        int index = indexOf(a, key);
        StdOut.println("Chỉ số nhỏ nhất: " + index);
    }
}