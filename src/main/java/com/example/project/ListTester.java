package com.example.project;

public class ListTester {
    public static <T> void circularLeftShift(List<T> list, int n) {
    if (list.empty()) {
        return;
    }
    for (int i = 0; i < n; i++) {
        T temp = list.retrieve();
        list.findNext();
        list.insert(temp);
        list.remove();
    }
}
    public static <T> void reverseCopy(DLL<T> l1, DLL<T> l2) {
    if (l1.empty()) {
        return;
    }

    l1.findFirst();
    Node<T> temp = l1.head;

    while (temp != null) {
        l2.insert(temp.data);
        temp = temp.next;
    }
    DLLNode<T> current = l2.head;
    DLLNode<T> previous = null;
    while (current != null) {
        DLLNode<T> nextNode = current.next;
        current.next = previous;
        current.previous = nextNode;
        previous = current;
        current = nextNode;
    }

    l2.head = previous;
}

}
