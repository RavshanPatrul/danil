import java.util.EmptyStackException;

 class CustomStack<T> {
    private Node<T> top;
    private int size;

    private static class Node<T> {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public CustomStack() {
        top = null;
        size = 0;
    }

    public void push(String element) {
        Node newNode = new Node<>(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public String pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        String data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public String peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    // Проверка на пустоту стека
    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        CustomStack<Integer> stack = new CustomStack<>();

        stack.push("Император человечества");
        stack.push("Хорус");
        stack.push("Ересь");

        System.out.println("Размер стека: " + stack.size());

        System.out.println("Верхний элемент: " + stack.peek());

        while (!stack.isEmpty()) {
            System.out.println("Удален элемент: " + stack.pop());
        }

        System.out.println("Стек пуст: " + stack.isEmpty());
    }
}
