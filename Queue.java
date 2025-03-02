class ArrayQueue<T> {
    private T[] items;
    private int front, rear, size, capacity;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.items = (T[]) new Object[capacity];
        this.front = this.rear = -1;
        this.size = 0;
    }

    // Добавление элемента в конец очереди
    public void enqueue(T element) {
        if (isFull()) {
            System.out.println("Очередь заполнена");
            return;
        }
        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }
        items[rear] = element;
        size++;
    }

    // Удаление элемента из начала очереди
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Очередь пуста");
            return null;
        }
        T temp = items[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        size--;
        return temp;
    }

    // Просмотр элемента в начале очереди
    public T peek() {
        if (isEmpty()) {
            System.out.println("Очередь пуста");
            return null;
        }
        return items[front];
    }

    // Проверка на пустоту
    public boolean isEmpty() {
        return size == 0;
    }

    // Проверка на заполненность
    public boolean isFull() {
        return size == capacity;
    }

    // Вывод всех элементов очереди
    public void display() {
        if (isEmpty()) {
            System.out.println("Очередь пуста");
            return;
        }
        int tempFront = front;
        for (int i = 0; i < size; i++) {
            System.out.print(items[tempFront] + " ");
            tempFront = (tempFront + 1) % capacity;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        // Создание очереди с максимальной вместимостью 5 элементов
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);

        // Проверка на пустоту
        System.out.println("Очередь пуста: " + queue.isEmpty()); // Вывод: true

        // Добавление элементов в очередь
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        // Вывод всех элементов очереди
        System.out.println("Элементы очереди:");
        queue.display(); // Вывод: 10 20 30 40 50

        // Проверка на заполненность
        System.out.println("Очередь заполнена: " + queue.isFull()); // Вывод: true

        // Попытка добавить еще один элемент в заполненную очередь
        queue.enqueue(60); // Вывод: Очередь заполнена

        // Просмотр элемента в начале очереди
        System.out.println("Элемент в начале очереди: " + queue.peek()); // Вывод: 10

        // Удаление элементов из очереди
        System.out.println("Удаленный элемент: " + queue.dequeue()); // Вывод: 10
        System.out.println("Удаленный элемент: " + queue.dequeue()); // Вывод: 20

        // Вывод оставшихся элементов очереди
        System.out.println("Оставшиеся элементы очереди:");
        queue.display(); // Вывод: 30 40 50

        // Проверка на пустоту после удаления элементов
        System.out.println("Очередь пуста: " + queue.isEmpty()); // Вывод: false

        // Удаление всех оставшихся элементов
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        // Проверка на пустоту после удаления всех элементов
        System.out.println("Очередь пуста: " + queue.isEmpty()); // Вывод: true
    }
}
