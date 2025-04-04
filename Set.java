import java.util.NoSuchElementException;

 class Set<T> {
    private Node<T> head; // Голова списка
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
    public Set() {
        head = null;
        size = 0;
    }

    // Добавление элемента в множество
    public void add(T data) {
        if (contains(data)) return; // Если элемент уже есть, не добавляем
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // Удаление элемента из множества
    public boolean remove(T data) {
        if (head == null) return false;
        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return true;
        }
        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Проверка наличия элемента в множестве
    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) return true;
            current = current.next;
        }
        return false;
    }

    // Печать множества
    public void printSet() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Set<String> set = new Set<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Apple"); // Повторное добавление не изменит множество
        set.printSet(); // Вывод: Apple Banana
        set.remove("Banana");
        set.printSet(); // Вывод: Apple
        System.out.println(set.contains("Apple")); // Вывод: true
    }
}
