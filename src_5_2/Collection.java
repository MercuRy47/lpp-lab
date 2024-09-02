public interface Collection {
    public void add(Object value);
    public void add(int index, Object value);
    public Object get(int index);
    public void set(int index, Object value);
    public void remove(Object value);
    public boolean find(Object value);
    public int size();
    public boolean isEmpty();
    public void show();
}