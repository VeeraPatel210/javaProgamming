interface Switchable {
    void on();
    void off();

    default void toggle() {
        on();
        off();
    }
}

class Fan implements Switchable {
    public void on() {
        System.out.println("Fan ON");
    }

    public void off() {
        System.out.println("Fan OFF");
    }
}

class Light implements Switchable {
    public void on() {
        System.out.println("Light ON");
    }

    public void off() {
        System.out.println("Light OFF");
    }
}

interface Permission {
    boolean allow(Switchable device, int hour);
}

class Switch {
    public static void main(String[] args) {

        Switchable[] devices = {
                new Fan(),
                new Light()
        };

        for (int i = 0; i < devices.length; i++)
            devices[i].toggle();

        Permission p1 = new Permission() {
            public boolean allow(Switchable d, int hour) {
                return hour >= 6 && hour <= 22;
            }
        };

        Permission p2 = (d, hour) -> hour >= 6 && hour <= 22;

        System.out.println("Anonymous: " + p1.allow(new Fan(), 10));
        System.out.println("Lambda: " + p2.allow(new Light(), 23));
    }
}