import java.util.Arrays;

public class ArrayList implements Collection {

    private int capacity;
    private int count;
    private Object[] arry;

    ArrayList(int size_arr) {
        this.capacity = size_arr;
        this.count = 0;
        this.arry = new Object[size_arr];
    }

    @Override
    public void add(Object value) {
        if (count >= capacity) {
            throw new RuntimeException("Array Out of Bounds");
        }
        arry[count++] = value;
    }

    @Override
    public void add(int index, Object value) {
        if (index < 0 || index >= capacity || count >= capacity) {
            throw new RuntimeException("Array Out of Bounds");
        }
        System.arraycopy(arry, index, arry, index + 1, count - index);
        arry[index] = value;
        count++;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= count) {
            throw new RuntimeException("not found");
        }
        return arry[index];
    }

    @Override
    public void set(int index, Object value) {
        if (index < 0 || index >= count) {
            throw new RuntimeException("not found");
        }
        arry[index] = value;
    }

    @Override
    public void remove(Object value) {
        int index = indexOf(value);
        if (index != -1) {
            System.arraycopy(arry, index + 1, arry, index, count - index - 1);
            arry[--count] = null;
        }
    }

    @Override
    public boolean find(Object value) {
        return indexOf(value) != -1;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void show() {
        System.out.print("[");
        for (int i = 0; i < count; i++) {
            System.out.print(arry[i]);
            if (i < count - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public int indexOf(Object value) {
        for (int i = 0; i < count; i++) {
            if (arry[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public int maxSize() {
        return capacity;
    }

    public boolean isFull() {
        return count == capacity;
    }
}
