import java.util.Scanner;

class Demo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] logs = {
                "09:30 rahul Hello everyone",
                "09:45 priya Good morning",
                "10:00 amit Hello friend"
        };

        System.out.print("Enter keyword: ");
        String key = sc.nextLine();

        int count = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < logs.length; i++) {

            String[] p = logs[i].split(" ", 3);

            if (p.length < 3)
                continue;

            if (p[2].toLowerCase().contains(key.toLowerCase())) {
                count++;
                result.append(p[0] + " " + p[1] + ": " + p[2] + "\n");
            }
        }

        System.out.println("Matches: " + count);
        System.out.println(result);
    }
}