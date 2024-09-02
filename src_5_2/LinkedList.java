public class LinkedList implements Collection{

    private class node {
        Object data;
        node link;
        node(Object d, node l){
            this.data = d;
            this.link = l;
        }
    };

    node head;
    node tail;
    int count;

    LinkedList(){
        head = null;
        tail = null;
        this.count = 0;
    }

    @Override
    public void add(Object value) {
        node Newnode = new node(value, null);
        if (isEmpty()) {
            head = Newnode;
            tail = Newnode;
        }else {
            tail.link = Newnode;
            tail = Newnode;
        }
        count++;
    }

    @Override
    public void add(int index, Object value) {
        if (index > count + 1){
            throw new IndexOutOfBoundsException("out of bound");
        }
        if (index == count + 1){
            add(value);
        }else {
            int indexF = 0;
            node NewNode = new node(value,null);
            node ptemp = null;

            for (node temp = head; temp != null; temp = temp.link){
                indexF++;
                if (indexF == index  - 1){
                    ptemp = temp;
                }
                if (indexF == index) {
                    NewNode.link = temp;
                    ptemp.link = NewNode;
                    count++;
                }
            }
        }
    }

    @Override
    public Object get(int index) {
        if (index > count){
            throw new IndexOutOfBoundsException("out of bound");
        }else {
            int i = 0;
            node temp = head;
            int indexD = 1;
            for (;temp != null ; temp = temp.link){
                if (index == indexD) {
                    return temp.data;
                }
                indexD++;
            }
            return -1;
        }
    }

    @Override
    public void set(int index, Object value) {
        if (index > count){
            throw new IndexOutOfBoundsException("out of bound");
        } else {
            int indexF = 0;
            for (node temp = head; temp != null; temp = temp.link) {
                indexF++;
                if (indexF == index) {
                    temp.data = value;
                }
            }
        }
    }

    @Override
    public void remove(Object value) {
        node ptemp = head;
        for (node temp = head; temp != null; temp = temp.link){
            if (temp.data == value){
                node keep = ptemp.link;
                ptemp.link = ptemp.link.link;
                keep = null;
                temp = ptemp;
                count--;
            }
            ptemp = temp;
        }
    }

    public void removeIndex(int index) {
        if (index > count || index < 1) {
            throw new IndexOutOfBoundsException("out of bound");
        }

        if (index == 1) {
            // Remove the head
            node temp = head;
            head = head.link;
            if (head == null) {
                tail = null;
            }
            temp = null;
        } else {
            node ptemp = head;
            for (int i = 1; i < index - 1; i++) {
                ptemp = ptemp.link;
            }
            node toRemove = ptemp.link;
            ptemp.link = toRemove.link;
            if (toRemove == tail) {
                tail = ptemp;
            }
            toRemove = null;
        }
        count--;
    }


    @Override
    public boolean find(Object value) {
        boolean isFine = false;
        for (node temp = head ; temp != null ; temp = temp.link){
            if (temp.data == value){
                isFine = true;
                break;
            }
            if (temp.data.equals(value)){
                return true;
            }
        }
        return isFine;
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
        node temp = head;
        while (temp != null){
            System.out.print(temp.data);
            if (temp.link != null){
                System.out.print(", ");
            }
            temp = temp.link;
        }
        System.out.println("]");
    }
}