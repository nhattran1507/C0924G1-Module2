package ReverseArray;

public class ArrayStack<T> implements StackADT<T> {
    private int top;
    private T[] stack;
    private final int DEFAUT_CAPACITY = 100;

    public ArrayStack() {
        top = 0;
        stack = (T[]) new Object[DEFAUT_CAPACITY];
    }
    public ArrayStack(int initialCapacity) {
        top = 0;
        stack = (T[]) new Object[initialCapacity];
    }

    @Override
    public void push(Object element) {

    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.top == 0;
    }

    @Override
    public int size() {
        return this.top;
    }

    @Override
    public void clear() {

    }
}
