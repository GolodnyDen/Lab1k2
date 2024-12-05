public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);

        stack.push(22);
        stack.push(233);
        stack.push(344);

        System.out.println(stack.pop());

        System.out.println(stack.peek());

        stack.push(4);

        System.out.println(stack.pop());
    }
}

