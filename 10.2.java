
import java.util.*;

class Buffer {
    Queue<Integer> queue = new LinkedList<>();
    int size = 3;

    synchronized void produce(int n) throws InterruptedException {
        while (queue.size() == size)
            wait();

        queue.add(n);
        System.out.println("Produced: " + n);
        notify();
    }

    synchronized int consume() throws InterruptedException {
        while (queue.isEmpty())
            wait();

        int n = queue.remove();
        System.out.println("Consumed: " + n);
        notify();
        return n;
    }
}

 class ProducerConsumer1 {
    public static void main(String[] args) throws InterruptedException {
        Buffer b = new Buffer();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++)
                    b.produce(i);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++)
                    b.consume();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println("All items produced and consumed");
    }
}
