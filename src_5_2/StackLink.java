public class StackLink implements Stack {

    private int top = -1;
    private LinkedList data;

    StackLink(){
        data = new LinkedList();
    }

    @Override
    public void push(Object value) {
        data.add(value);
        top++;
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            throw new RuntimeException("is empty");
        }
        Object value = peek();
        data.removeIndex(top + 1);  // Fix index to top + 1 to remove the correct element
        top--;
        return value;
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            throw new RuntimeException("is empty");
        }
        return data.get(top + 1);  // Fix index to top + 1 to access the correct element
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void show() {
        data.show();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
