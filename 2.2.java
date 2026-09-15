class CinemaShow {

    private String title;
    private int seatsAvailable;
    private final int capacity;
    private static int totalBooked = 0;

    CinemaShow(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
        this.seatsAvailable = capacity;
    }

    CinemaShow(String title) {
        this(title, 100);
    }

    boolean book(int n) {

        if (n <= seatsAvailable) {
            seatsAvailable -= n;
            totalBooked += n;
            return true;
        }

        return false;
    }

    void cancel(int n) {
        seatsAvailable += n;

        if (seatsAvailable > capacity) {
            seatsAvailable = capacity;
        }
    }

    int getSeatsAvailable() {
        return seatsAvailable;
    }

    static int getTotalBooked() {
        return totalBooked;
    }
}

class Main4 {
    public static void main(String[] args) {

        CinemaShow c = new CinemaShow("Avengers", 50);

        System.out.println(c.book(20));
        System.out.println("Seats: " + c.getSeatsAvailable());

        System.out.println(c.book(40));
        System.out.println("Seats: " + c.getSeatsAvailable());

        c.cancel(10);
        System.out.println("Seats: " + c.getSeatsAvailable());

        System.out.println(c.book(15));
        System.out.println("Seats: " + c.getSeatsAvailable());

        System.out.println("Total Booked: " + CinemaShow.getTotalBooked());
    }
}