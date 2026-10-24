import java.util.Scanner;
class Driver {

    static String strength(String pw) {

        int count = 0;

        if (pw.length() >= 8)
            count++;

        if (pw.matches(".*[A-Z].*"))
            count++;

        if (pw.matches(".*[0-9].*"))
            count++;

        if (pw.matches(".*[^a-zA-Z0-9].*"))
            count++;

        if (count <= 1)
            return "Weak";
        else if (count <= 3)
            return "Medium";
        else
            return "Strong";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password: ");
        String pw = sc.nextLine();

        System.out.println("Strength: " + strength(pw));
    }
}