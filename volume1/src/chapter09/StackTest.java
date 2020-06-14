package chapter09;

import java.util.Stack;

public class StackTest {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("abc");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}
