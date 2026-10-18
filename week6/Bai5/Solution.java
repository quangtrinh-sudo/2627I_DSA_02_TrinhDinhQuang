import java.util.Scanner;
import java.util.ArrayList;

public class Solution {

    static void partition(int[] ar) {
        int pivot = ar[0];
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();

        for (int x : ar) {
            if (x < pivot) {
                left.add(x);
            } else if (x > pivot) {
                right.add(x);
            } else {
                equal.add(x);
            }
        }

        int index = 0;
        for (int x : left) {
            ar[index++] = x;
        }
        for (int x : equal) {
            ar[index++] = x;
        }
        for (int x : right) {
            ar[index++] = x;
        }

        printArray(ar);
    }

    static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        partition(ar);
        in.close();
    }
}