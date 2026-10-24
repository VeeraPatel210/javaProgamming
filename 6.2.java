import java.util.Scanner;

interface Notifier {
    void send(String msg);
}

interface Urgent {
}

class Email implements Notifier, Urgent {
    public void send(String msg) {
        System.out.println("Email: " + msg);
    }
}

class SMS implements Notifier {
    public void send(String msg) {
        System.out.println("SMS: " + msg);
    }
}

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter message: ");
        String msg = sc.nextLine();

        Notifier[] n = {
                new Email(),
                new SMS()
        };

        for (int i = 0; i < n.length; i++) {

            n[i].send(msg);

            if (n[i] instanceof Urgent)
                n[i].send(msg);
        }
    }
}