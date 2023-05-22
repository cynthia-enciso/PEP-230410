import java.util.ArrayDeque;
import java.util.Stack;

// stack: push, pop, peek
public class StackOrDeque {
    public static void main(String[] args) {
        // deque, head and tail
        ArrayDeque<Integer> dequeStack = new ArrayDeque<>();
        System.out.println("DequeStack:");
        dequeStack.push(1);
        dequeStack.push(2);
        dequeStack.push(3);
        dequeStack.push(4);
        dequeStack.push(5);
        System.out.println(dequeStack);
        dequeStack.pop();
        System.out.println(dequeStack);

        System.out.println("Iterating over a Deque Stack:");
        for(Integer element : dequeStack) {
            System.out.println(element);
        }

        // has indexes!
        // top = end, bottom = beginning
        System.out.println("Stack:");
        Stack<Integer> stack2 = new Stack<>();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        stack2.push(4);
        stack2.push(5);
        System.out.println(stack2);
        stack2.pop();
        System.out.println(stack2);
        // when iterating, doesn't start with top element, not very stack-like
        System.out.println("Iterating over a Stack Stack:");
        for(Integer element : stack2) {
            System.out.println(element);
        }
        // https://stackoverflow.com/questions/12524826/why-should-i-use-deque-over-stack
    }
}
