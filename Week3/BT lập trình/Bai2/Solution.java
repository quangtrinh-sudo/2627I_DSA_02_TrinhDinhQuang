import java.util.Stack;

public class Solution {

    public static String isBalanced(String s) {
        Stack<Character> st = new Stack<>();

        for (char a : s.toCharArray()) {
            // b là ngoặc mở, đẩy vào stack
            if (a == '(' || a == '[' || a == '{') {
                st.push(a);
            } 
            // b là ngoặc đóng, kiểm tra với đỉnh stack
            else {
                if (st.isEmpty()) return "NO";
                
                char b = st.pop(); // Lấy ngoặc mở gần nhất
                
                if (a == ')' && b != '(') return "NO";
                if (a == ']' && b != '[') return "NO";
                if (a == '}' && b != '{') return "NO";
            }
        }

        return st.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] A) {
        String[] B = {"{[(())]}", "{[(])}", "{{[[(())]]}}"};

        for (String a : B) {
            System.out.println(isBalanced(a));
        }
    }
}