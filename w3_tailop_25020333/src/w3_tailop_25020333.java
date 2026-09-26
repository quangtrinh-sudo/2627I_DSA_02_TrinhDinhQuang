import java.util.Scanner;
import java.util.Stack;

public class w3_tailop_25020333 {

    static int doUuTien(char c) {
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Stack<Character> st = new Stack<>();
        String res = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') continue;

            if (Character.isLetterOrDigit(c)) {
                res += c;
            } else if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    res += st.pop();
                }
                if (!st.isEmpty()) st.pop();
            } else {
                while (!st.isEmpty() && doUuTien(st.peek()) >= doUuTien(c)) {
                    res += st.pop();
                }
                st.push(c);
            }
        }

        while (!st.isEmpty()) {
            res += st.pop();
        }

        System.out.println(res);
    }
}
