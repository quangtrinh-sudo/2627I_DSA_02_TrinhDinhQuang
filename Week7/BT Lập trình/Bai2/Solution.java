import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner A = new Scanner(System.in);
        String a = A.next();
        String b = new StringBuilder(a).reverse().toString();
        if (a.equals(b)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}