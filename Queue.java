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

    public T peek() {
        if (isEmpty()) {
            System.out.println("Очередь пуста");
            return null;
        }
        return items[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

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
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);

        System.out.println("Очередь пуста: " + queue.isEmpty()); 

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println("Элементы очереди:");
        queue.display(); 

        System.out.println("Очередь заполнена: " + queue.isFull()); 

        queue.enqueue(60); 

        System.out.println("Элемент в начале очереди: " + queue.peek()); 

        System.out.println("Удаленный элемент: " + queue.dequeue()); 
        System.out.println("Удаленный элемент: " + queue.dequeue()); 

        System.out.println("Оставшиеся элементы очереди:");
        queue.display(); 

        System.out.println("Очередь пуста: " + queue.isEmpty()); 

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        System.out.println("Очередь пуста: " + queue.isEmpty()); 
    }
}
