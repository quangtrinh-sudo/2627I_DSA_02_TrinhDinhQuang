import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        Stack<Integer> A = new Stack<>(); // Stack dùng để enqueue
        Stack<Integer> B = new Stack<>(); // Stack dùng để dequeue và print

        while (q-- > 0) {
            int type = sc.nextInt();

            if (type == 1) {
                int x = sc.nextInt();
                A.push(x); // Thêm phần tử vào A
            } else {
                // Nếu B rỗng, chuyển toàn bộ phần tử từ A sang B
                if (B.isEmpty()) {
                    while (!A.isEmpty()) {
                        B.push(A.pop());
                    }
                }

                if (type == 2) {
                    B.pop(); // Xóa phần tử ở đầu Queue
                } else if (type == 3) {
                    System.out.println(B.peek()); // In phần tử ở đầu Queue
                }
            }
        }
        sc.close();
    }
}