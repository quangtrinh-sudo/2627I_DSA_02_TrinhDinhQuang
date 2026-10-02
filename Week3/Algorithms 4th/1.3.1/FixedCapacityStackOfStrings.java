import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedCapacityStackOfStrings implements Iterable<String> {
    private String[] a;  // Mảng chứa các phần tử
    private int n;       // Số lượng phần tử hiện tại trong stack

    // Khởi tạo stack rỗng với sức chứa cố định
    public FixedCapacityStackOfStrings(int capacity) {
        a = new String[capacity];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    // Hàm isFull() theo yêu cầu bài 1.3.1
    public boolean isFull() {
        return n == a.length;
    }

    public void push(String item) {
        if (isFull()) {
            throw new RuntimeException("Stack overflow");
        }
        a[n++] = item;
    }

    public String pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        return a[--n];
    }

    public String peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        return a[n - 1];
    }

    public Iterator<String> iterator() {
        return new ReverseArrayIterator();
    }

    public class ReverseArrayIterator implements Iterator<String> {
        private int i = n - 1;

        public boolean hasNext() {
            return i >= 0;
        }

        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }
    }

    public static void main(String[] args) {
        int max = Integer.parseInt(args[0]);
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(max);

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                if (!stack.isFull()) {
                    stack.push(item);
                } else {
                    StdOut.println("STACK FULL");
                }
            } else if (stack.isEmpty()) {
                StdOut.println("BAD INPUT");
            } else {
                StdOut.print(stack.pop() + " ");
            }
        }
        StdOut.println();

        StdOut.print("Left on stack: ");
        for (String s : stack) {
            StdOut.print(s + " ");
        }
        StdOut.println();
    }
}