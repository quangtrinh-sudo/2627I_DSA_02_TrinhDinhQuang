import java.util.*;

public class Solution {

    public static List<Integer> countingSort(List<Integer> arr) {
        // Tạo danh sách kích thước 100, ban đầu toàn số 0
        List<Integer> result = new ArrayList<>(Collections.nCopies(100, 0));
        
        // Đếm số lần xuất hiện
        for (int num : arr) {
            result.set(num, result.get(num) + 1);
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }
        
        List<Integer> result = countingSort(arr);
        for (int count : result) {
            System.out.print(count + " ");
        }
    }
}