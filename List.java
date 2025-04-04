import java.util.NoSuchElementException;

class SinglyLinkedList<T> {
    private Node<T> head; // Голова списка
    private Node<T> tail; // Хвост списка
    private int size; // Количество элементов

    // Узел списка
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Конструктор
    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Добавление элемента в конец списка
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Удаление первого вхождения элемента
    public boolean remove(T data) {
        if (head == null) return false;
        if (head.data.equals(data)) {
            head = head.next;
            if (head == null) tail = null;
            size--;
            return true;
        }
        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                if (current.next == null) tail = current;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Печать списка
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.printList(); // Вывод: Apple Banana Cherry
        list.remove("Banana");
        list.printList(); // Вывод: Apple Cherry
    }
}
