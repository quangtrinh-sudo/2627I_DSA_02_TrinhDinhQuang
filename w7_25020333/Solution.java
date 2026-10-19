import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner A = new Scanner(System.in);
        int n = A.nextInt();
        PriorityQueue<Integer> a = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> b = new PriorityQueue<>();
        
        for (int i = 0; i < n; i++) {
            int B = A.nextInt();
            if (a.isEmpty() || B <= a.peek()) {
                a.add(B);
            } else {
                b.add(B);
            }
            
            if (a.size() > b.size() + 1) {
                b.add(a.poll());
            } else if (b.size() > a.size()) {
                a.add(b.poll());
            }
            
            if (a.size() == b.size()) {
                double res = (a.peek() + b.peek()) / 2.0;
                System.out.printf("%.1f\n", res);
            } else {
                double res = a.peek();
                System.out.printf("%.1f\n", res);
            }
        }
    }
}