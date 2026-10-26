
class Booking {
    int seatsLeft = 5;
    int booked = 0;

    void book() {
        if (seatsLeft > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            seatsLeft--;
            booked++;
            System.out.println("Seat booked");
        }
    }

    synchronized void syncBook() {
        if (seatsLeft > 0) {
            seatsLeft--;
            booked++;
            System.out.println("Seat booked");
        }
    }
}

class SeatBookingRace {
    public static void main(String[] args) throws InterruptedException {
        Booking b1 = new Booking();
        Thread[] t1 = new Thread[10];

        for (int i = 0; i < 10; i++) {
            t1[i] = new Thread(() -> b1.book());
            t1[i].start();
        }

        for (Thread t : t1)
            t.join();

        System.out.println("Without synchronization: " + b1.booked);

        Booking b2 = new Booking();
        Thread[] t2 = new Thread[10];

        for (int i = 0; i < 10; i++) {
            t2[i] = new Thread(() -> b2.syncBook());
            t2[i].start();
        }

        for (Thread t : t2)
            t.join();

        System.out.println("With synchronization: " + b2.booked);
        System.out.println("Seats left: " + b2.seatsLeft);
    }
}
