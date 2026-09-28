import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] A) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();

        String s = "";
        Stack<String> st = new Stack<>();

        while (Q-- > 0) {
            int t = sc.nextInt();

            if (t == 1) {
                st.push(s);
                s += sc.next();
            } else if (t == 2) {
                st.push(s);
                int k = sc.nextInt();
                s = s.substring(0, s.length() - k);
            } else if (t == 3) {
                int k = sc.nextInt();
                System.out.println(s.charAt(k - 1));
            } else if (t == 4) {
                s = st.pop();
            }
        }
        sc.close();
    }
}