import java.util.Scanner;
import java.util.Stack;

public class InfixExpression {
    public static void main(String[] args) {
        Stack<String> vals = new Stack<>();
        Stack<String> ops = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String s = scanner.next();
            
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                ops.push(s);
            } else if (s.equals(")")) {
                String op = ops.pop();
                String val2 = vals.pop();
                String val1 = vals.pop();
                String subExpr = "( " + val1 + " " + op + " " + val2 + " )";
                vals.push(subExpr);
            } else {
                vals.push(s);
            }
        }

        System.out.println(vals.pop());
        scanner.close();
    }
}