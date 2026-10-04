import java.util.Scanner;
import java.util.Stack;

public class EvaluatePostfix {

    public static int tinhToan(int a, int b, String op) {
        if (op.equals("+")) return a + b;
        if (op.equals("-")) return a - b;
        if (op.equals("*")) return a * b;
        if (op.equals("/")) return a / b;
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();

        while (sc.hasNext()) {
            String token = sc.next();
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = st.pop();
                int a = st.pop();
                st.push(tinhToan(a, b, token));
            } else {
                st.push(Integer.parseInt(token));
            }
        }

        System.out.println(st.pop());
        sc.close();
    }
}