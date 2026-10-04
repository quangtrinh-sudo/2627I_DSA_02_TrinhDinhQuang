import java.util.Scanner;
import java.util.Stack;

public class Parentheses {
    private static final char LEFT_PAREN     = '(';
    private static final char RIGHT_PAREN    = ')';
    private static final char LEFT_Thuật toán kiểm tra tính cân bằng của các dấu ngoặc sử dụng cấu trúc dữ liệu **Stack (Ngăn xếp)** hoạt động theo nguyên lý vào sau - ra trước (LIFO):


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Parentheses {

    public static boolean isBalanced(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

           
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
           
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char open = stack.pop();
                if (!isMatchingPair(open, c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String input = scanner.next();
            System.out.println(isBalanced(input));
        }
        scanner.close();
    }
}