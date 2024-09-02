import java.util.ArrayList;

public class StackArray implements Stack {
    private int top = -1;
    private Object[] data;

    StackArray(int size) {
        data = new Object[size];
    }

    @Override
    public void push(Object value) {
        if (isFull()) {
            throw new ArrayStoreException("is full");
        }
        top++;
        data[top] = value;
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("is empty");
        }
        Object value = data[top];
        data[top] = null; // Reset the value to null after popping
        top--;
        return value;
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("is empty");
        }
        return data[top];
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public void show() {
        System.out.print("[");
        for (int i = 0; i < data.length; i++) {
            System.out.print(i + "=>" + data[i]);
            if (i < data.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == data.length - 1;
    }
}
