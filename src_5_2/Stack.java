public interface Stack {
    void push(Object value);
    Object pop();
    Object peek();
    int size();
    void show();
    boolean isEmpty();
}