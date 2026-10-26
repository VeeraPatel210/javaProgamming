
import java.util.*;

 class UniqueVisitors {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Veera", "Riya", "Amit", "Veera", "Neha", "Riya", "Raj"
        );

        HashSet<String> set = new HashSet<>(names);
        LinkedHashSet<String> ordered = new LinkedHashSet<>(names);

        System.out.println("Unique visitors: " + set.size());

        System.out.println("First three distinct names:");
        int count = 0;

        for (String name : ordered) {
            if (count == 3)
                break;

            System.out.println(name);
            count++;
        }
    }
}
