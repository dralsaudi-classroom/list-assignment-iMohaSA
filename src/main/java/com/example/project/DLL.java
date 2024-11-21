package com.example.project;

public class DLL<T> {
    public DLLNode<T> head;
    public DLLNode<T> current;

    public DLL() {
        head = current = null;
    }
    public boolean empty() {
        return head == null;
    }
    public boolean last() {
        return current.next == null;
    }
    public boolean first() {
        return current.previous == null;
    }
    public boolean full() {
        return false;
    }
    public void findFirst() {
        current = head;
    }
    public void findNext() {
        current = current.next;
    }
    public void findPrevious() {
        current = current.previous;
    }
    public T retrieve() {
        return current.data;
    }
    public void update(T val) {
        current.data = val;
    }
    public void insert(T val) {
        DLLNode<T> tmp = new DLLNode<T>(val);
        if(empty()) {
            current = head = tmp;
        }
        else {
            tmp.next = current.next;
            tmp.previous = current;
            if(current.next != null)
                current.next.previous = tmp;
            current.next = tmp;
            current = tmp;
        }
    }
    public void remove() {
        if(current == head) {
            head = head.next;
            if(head != null)
                head.previous = null;
        }
        else {
            current.previous.next = current.next;
            if(current.next != null)
                current.next.previous = current.previous;
        }
        if(current.next == null)
            current = head;
        else
            current = current.next;
    }
    public void removeBetween(T e1, T e2) {
        if (empty()) {
            return;
        }

        DLLNode<T> node = head;
        while (node != null && !node.data.equals(e1)) {
            node = node.next;
        }

        if (node == null || node.next == null) {
            return;
        }

        DLLNode<T> endNode = node.next;
        while (endNode != null && !endNode.data.equals(e2)) {
            endNode = endNode.next;
        }

        if (endNode == null) {
            return;
        }

        node.next = endNode;
        endNode.previous = node;

        current = head;
    }
    public static <T> void reverseCopy(DLL<T> list1, DLL<T> list2) {
        DLLNode<T> temp = list1.head;


        while (temp != null && temp.next != null) {
            temp = temp.next;
        }


        while (temp != null) {
            list2.insert(temp.data);
            temp = temp.previous;
        }
    }

}
