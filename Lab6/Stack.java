public class Stack<T> {
    private T[] data;  
    private int size;  

    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        if (size == data.length) {
            throw new IllegalStateException("Стек переполнен");
        }
        data[size] = element;
        size++;
    }

    public T pop() {
        if (size == 0) {
            throw new IllegalStateException("Стек пуст");
        }
        T topElement = data[size - 1];
        data[size - 1] = null;
        size--;
        return topElement;
    }

    public T peek() {
        if (size == 0) {
            throw new IllegalStateException("Стек пуст");
        }
        return data[size - 1];
    }

}
