
class Counter {
    int count = 0;

    void increment() {
        count++;
    }

    synchronized void syncIncrement() {
        count++;
    }
}

class CounterRace {
    public static void main(String[] args) throws InterruptedException {
        int n = 5;
        int times = 100000;

        Counter c1 = new Counter();
        Thread[] t1 = new Thread[n];

        for (int i = 0; i < n; i++) {
            t1[i] = new Thread(() -> {
                for (int j = 0; j < times; j++)
                    c1.increment();
            });
            t1[i].start();
        }

        for (Thread t : t1)
            t.join();

        System.out.println("Without synchronization: " + c1.count);

        Counter c2 = new Counter();
        Thread[] t2 = new Thread[n];

        for (int i = 0; i < n; i++) {
            t2[i] = new Thread(() -> {
                for (int j = 0; j < times; j++)
                    c2.syncIncrement();
            });
            t2[i].start();
        }

        for (Thread t : t2)
            t.join();

        System.out.println("With synchronization: " + c2.count);
        System.out.println("Expected count: " + (n * times));
    }
}
