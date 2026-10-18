import java.util.Scanner;

public class Solution {

    static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    static int partition(int[] a, int l, int r) {
        int pivot = a[r];
        int i = l;
        for (int j = l; j < r; j++) {
            if (a[j] <= pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, r);
        return i;
    }

    static int quickSelect(int[] a, int l, int r, int k) {
        if (l <= r) {
            int p = partition(a, l, r);
            if (p == k) {
                return a[p];
            } else if (p > k) {
                return quickSelect(a, l, p - 1, k);
            } else {
                return quickSelect(a, p + 1, r, k);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int k = n / 2;
        System.out.println(quickSelect(a, 0, n - 1, k));
        sc.close();
    }
}