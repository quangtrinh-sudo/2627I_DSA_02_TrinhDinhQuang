import java.util.Scanner;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Scanner A = new Scanner(System.in);
        int a = A.nextInt();
        int b = A.nextInt();
        PriorityQueue<Integer> c = new PriorityQueue<>();
        for (int i = 0; i < a; i++) {
            c.add(A.nextInt());
        }
        int d = 0;
        while (c.peek() < b) {
            if (c.size() < 2) {
                d = -1;
                break;
            }
            int e = c.poll();
            int f = c.poll();
            int g = e + 2 * f;
            c.add(g);
            d++;
        }
        System.out.println(d);
    }
}