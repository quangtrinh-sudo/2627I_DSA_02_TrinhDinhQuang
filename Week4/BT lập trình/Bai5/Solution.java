import java.util.*;

public class Solution {

    public static void insertionSortPart2(int n, List<Integer> arr) {
        for (int i = 1; i < n; i++) {
            int key = arr.get(i);
            int j = i - 1;
            
            // Tìm vị trí thích hợp và dời các phần tử lớn hơn key sang phải
            while (j >= 0 && arr.get(j) > key) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, key);
            
            // In mảng ra sau mỗi lần chèn xong một phần tử
            printArray(arr);
        }
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
        insertionSortPart2(n, arr);
    }
}