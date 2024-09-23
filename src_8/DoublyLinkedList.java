public class DoublyLinkedList implements Collection {

    class Node {
        Object data;
        Node link;
        Node plink;

        Node(Object d, Node l, Node pl) {
            data = d;
            link = l;
            plink = pl;
        }
    }

    private Node head;
    private Node tail;
    private int count;

    public DoublyLinkedList() {
        count = 0;
        head = null;
        tail = null;
    }

    @Override
    public void add(Object value) {
        Node newNode = new Node(value, null, tail);
        if (tail != null) {
            tail.link = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = newNode;
        }
        count++;
    }

    @Override
    public void add(int index, Object value) {
        if (index <= 0 || index > count + 1) {
            throw new IndexOutOfBoundsException("out of bound");
        }
        if (index == count+1) {
            add(value);
        } else if (index == 1) {
            Node newNode = new Node(value, head, null);
            head.plink = newNode;
            head = newNode;
            count++;
        } else {
            Node current = head;
            for (int i = 1; i < index; i++) {
                current = current.link;
            }
            Node newNode = new Node(value, current, current.plink);
            current.plink.link = newNode;
            current.plink = newNode;
            count++;
        }
    }

    @Override
    public Object get(int index) {
        if (index <= 0 || index > count) {
            throw new IndexOutOfBoundsException("out of bound");
        }
        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.link;
        }
        return current.data;
    }

    @Override
    public void set(int index, Object value) {
        if (index <= 0 || index > count) {
            throw new IndexOutOfBoundsException("out of bound");
        }
        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.link;
        }
        current.data = value;
    }

    @Override
    public void remove(Object value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
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

    public boolean find(Object value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
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
        System.out.print("[ ");
        while (current != null) {
            System.out.print(current.data);
            if(current.link != null){
                System.out.print(", ");
            }else{
                System.out.print(" ");
            }
            current = current.link;
        }
        System.out.println("]");
    }

    public void show_backward() {
        Node current = tail;
        System.out.print("[ ");
        while (current != null) {
            System.out.print(current.data);
            if(current.plink != null){
                System.out.print(", ");
            }else{
                System.out.print(" ");
            }
            current = current.plink;
        }
        System.out.println("]");
    }


    public void sort_bubble() {
        if (head == null) {
            return; // Empty list
        }

        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current != null && current.link != null) {
                if (Integer.parseInt(current.data.toString()) > Integer.parseInt(current.link.data.toString())) {
                    // Swap data between current and current.link
                    Object temp = current.data;
                    current.data = current.link.data;
                    current.link.data = temp;
                    swapped = true;
                }
                current = current.link;
            }
        } while (swapped);
    }

    public void sort_shell() {
        if (head == null || head.link == null) {
            return; // Empty or single-element list is already sorted
        }

        int n = count;
        int gap = n / 2;

        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                Node keyNode = getNodeAtIndex(i);
                Object key = keyNode.data;
                int keyValue = Integer.parseInt(key.toString());

                int j = i;
                while (j >= gap && Integer.parseInt(getNodeAtIndex(j - gap).data.toString()) > keyValue) {
                    Node currentNode = getNodeAtIndex(j);
                    Node previousNode = getNodeAtIndex(j - gap);

                    // Swap data between currentNode and previousNode
                    currentNode.data = previousNode.data;
                    j -= gap;
                }
                Node targetNode = getNodeAtIndex(j);
                targetNode.data = key;
            }
            gap /= 2;
        }
    }

    // Helper method to get node at a specific index
    private Node getNodeAtIndex(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.link;
        }
        return current;
    }

}