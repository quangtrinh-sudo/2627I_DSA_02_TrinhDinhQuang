import edu.princeton.cs.algs4.Stack;

public class CopyStack {

    public static Stack<String> copy(Stack<String> s) {
        Stack<String> temp = new Stack<>();
        Stack<String> res = new Stack<>();

        for (String item : s) {
            temp.push(item);
        }

        for (String item : temp) {
            res.push(item);
        }

        return res;
    }

    public static void main(String[] args) {
        Stack<String> st = new Stack<>();
        st.push("1");
        st.push("2");
        st.push("3");

        Stack<String> copied = copy(st);

        for (String item : copied) {
            System.out.print(item + " ");
        }
    }
}