import java.util.*;

public class Solution {

    public static void insertionSort1(int n, List<Integer> arr) {
        int key = arr.get(n - 1);
        int i = n - 2;

        // Dời các phần tử lớn hơn key sang phải và in mảng sau mỗi lần dời
        while (i >= 0 && arr.get(i) > key) {
            arr.set(i + 1, arr.get(i));
            printArray(arr);
            i--;
        }

        // Đặt key vào đúng vị trí và in mảng lần cuối
        arr.set(i + 1, key);
        printArray(arr);
    }

    private static void printArray(List<Integer> arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }
        insertionSort1(n, arr);
    }
}