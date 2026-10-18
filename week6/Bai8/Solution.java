import java.util.Scanner;

class PriorityQueue {
    int[] a;
    int M;

    public PriorityQueue(int k) {
        a = new int[k];
        M = 0;
    }

    void insert(int x) {
        a[M] = x;
        M++;
    }

    int deleteMin() {
        int minIdx = 0;
        for (int i = 1; i < M; i++) {
            if (a[i] < a[minIdx]) {
                minIdx = i;
            }
        }
        int minVal = a[minIdx];
        a[minIdx] = a[M - 1];
        M--;
        return minVal;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        PriorityQueue pq = new PriorityQueue(k);
        
        pq.insert(5);
        pq.insert(2);
        pq.insert(9);
        
        System.out.println(pq.deleteMin());
        System.out.println(pq.deleteMin());
        
        sc.close();
    }
}