public class DoublyLinkedList implements Collection {

    class Node {
        Object data;
        Node link;
        Node plink;

        Node(Object d, Node n, Node p) {
            data = d;
            link = n;
            plink = p;
        }
    }

    private Node head;
    private Node tail;
    private int count;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        this.count = 0;
    }

    @Override
    public void add(Object value) {
        Node newNode = new Node(value, null, null);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.link = newNode;
            newNode.plink = tail;
            tail = newNode;
        }
        count++;
    }

    @Override
    public void add(int index, Object value) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("out of bound");
        }

        Node newNode = new Node(value, null, null);

        if (index == 0) {
            if (head != null) {
                newNode.link = head;
                head.plink = newNode;
            }
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else if (index == count) {
            tail.link = newNode;
            newNode.plink = tail;
            tail = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.link;
            }
            newNode.link = current;
            newNode.plink = current.plink;
            current.plink.link = newNode;
            current.plink = newNode;
        }
        count++;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("out of bound");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.link;
        }
        return current.data;
    }

    @Override
    public void set(int index, Object value) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("out of bound");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.link;
        }
        current.data = value;
    }

    @Override
    public void remove(Object value) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(value)) {
                if (current.plink != null) {
                    current.plink.link = current.link;
                } else {
                    head = current.link;
                }
                if (current.link != null) {
                    current.link.plink = current.plink;
                } else {
                    tail = current.plink;
                }
                count--;
            }
            current = current.link;
        }
    }


    @Override
    public boolean find(Object value) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(value)) {
                return true;
            }
            current = current.link;
        }
        return false;
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
        Node current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.data);
            if (current.link != null) {
                System.out.print(", ");
            }
            current = current.link;
        }
        System.out.println("]");
    }

    public void show_backward() {
        Node current = tail;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.data);
            if (current.plink != null) {
                System.out.print(", ");
            }
            current = current.plink;
        }
        System.out.println("]");
    }
}