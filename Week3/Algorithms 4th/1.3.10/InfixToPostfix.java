import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {

    
    public static int uuTien(char c) {
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        if (c == '^') return 3;
        return -1;
    }

    
    public static String infixToPostfix(String exp) {
        StringBuilder res = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            
            if (c == ' ') continue;

            
            if (Character.isLetterOrDigit(c)) {
                res.append(c).append(" ");
            }
            
            else if (c == '(') {
                st.push(c);
            }
            
            else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    res.append(st.pop()).append(" ");
                }
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                }
            }
            
            else {
                while (!st.isEmpty() && uuTien(c) <= uuTien(st.peek())) {
                    res.append(st.pop()).append(" ");
                }
                st.push(c);
            }
        }

       
        while (!st.isEmpty()) {
            res.append(st.pop()).append(" ");
        }

        return res.toString().trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            String infix = sc.nextLine();
            System.out.println(infixToPostfix(infix));
        }
        sc.close();
    }
}