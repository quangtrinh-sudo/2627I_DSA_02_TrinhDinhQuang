import java.util.Scanner;
import java.util.Random;

public class QuickSortDemo {
    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void shuffle(int[] a) {
        Random r = new Random();
        for (int i = a.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            swap(a, i, j);
        }
    }

    public static int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, high);
        return i + 1;
    }

    public static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pi = partition(a, low, high);
            quickSort(a, low, pi - 1);
            quickSort(a, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] a1 = a.clone();
        long start1 = System.currentTimeMillis();
        quickSort(a1, 0, n - 1);
        long end1 = System.currentTimeMillis();

        int[] a2 = a.clone();
        long start2 = System.currentTimeMillis();
        shuffle(a2);
        quickSort(a2, 0, n - 1);
        long end2 = System.currentTimeMillis();

        System.out.println("Time khong shuffle: " + (end1 - start1) + "ms");
        System.out.println("Time co shuffle: " + (end2 - start2) + "ms");
        
        sc.close();
    }
}