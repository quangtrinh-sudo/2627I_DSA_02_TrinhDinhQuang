import java.util.List;

public class Solution {

    public static int equalStacks(List<Integer> A, List<Integer> B, List<Integer> C) {
        int a = 0, b = 0, c = 0;

        for (int x : A) a += x;
        for (int x : B) b += x;
        for (int x : C) c += x;

        int i = 0, j = 0, k = 0;

        while (a != b || b != c) {
            if (a >= b && a >= c) {
                a -= A.get(i++);
            } else if (b >= a && b >= c) {
                b -= B.get(j++);
            } else {
                c -= C.get(k++);
            }
        }

        return a;
    }
}