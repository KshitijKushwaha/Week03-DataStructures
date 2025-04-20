import java.util.Stack;

public class SortStackUsingRecursion {

    public static void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element >= stack.peek()) {
            stack.push(element);
            return;
        }

        int topElement = stack.pop();
        insertSorted(stack, element);
        stack.push(topElement);
    }

    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int topElement = stack.pop();
            sortStack(stack);
            insertSorted(stack, topElement);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);
        
        System.out.println("Original Stack: " + stack);
        
        sortStack(stack);
        
        System.out.println("Sorted Stack: " + stack);
    }
}
