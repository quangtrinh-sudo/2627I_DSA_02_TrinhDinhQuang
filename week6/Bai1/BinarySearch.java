import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        
        int l = 0, r = n - 1;
        int kq = -1;
        
        while (l <= r) {
            int mid = l + (r - l) / 2;
            
            if (a[mid] == x) {
                kq = mid;
                break;
            } else if (a[mid] < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        System.out.println(kq);
        sc.close();
    }
}