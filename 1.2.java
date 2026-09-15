import java.util.Scanner;

record Vehicle(String number, String type){
}

class Main2{
    public static void main(String args[])
    {
        int total=0;
        int bike=0;
        int car=0;
        int truck=0;

        Scanner sc= new Scanner(System.in);

        while(true)
        {
            System.out.println("Enter vehicle number: ");
            String num=sc.nextLine().toLowerCase();

            if(num.equals("done"))
            {
                break;
            }

            System.out.println("Enter vehicle type: ");
            String type = sc.nextLine().toLowerCase();

            Vehicle v= new Vehicle(num,type);

            int toll = switch (v.type()) {
                case "bike" -> 20;
                case "car" -> 50;
                case "truck" -> 150;
                default -> 0;
            };
            total+=toll;

            switch(v.type())
            {
              case "bike" ->bike++;
              case "truck" -> truck++;
              case "car" ->car++;
            };

        }
        String mostFrequent;
        if (car >= bike && car >= truck) {
            mostFrequent = "car";
        } else if (bike >= car && bike >= truck) {
            mostFrequent = "bike";
        } else {
            mostFrequent = "truck";
        }
        System.out.println("Total toll: " + total);
        System.out.println("Most frequent: " + mostFrequent);
    }
}