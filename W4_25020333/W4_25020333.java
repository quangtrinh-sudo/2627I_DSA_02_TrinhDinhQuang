import java.util.Scanner;

public class W4_25020333 {

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        int[] citations = new int[n];


        for (int i = 0; i < n; i++) {
            citations[i] = sc.nextInt();
        }


        selectionSort(citations);

        int hIndex = 0;
        for (int i = 0; i < n; i++) {
            int count = n - i;
            if (citations[i] >= count) {
                hIndex = count;
                break;
            }
        }

        System.out.println(hIndex);

        sc.close();
    }
}